package br.edu.infnet.approupas.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.approupas.model.exceptions.ClienteInvalidoException;

@Entity
@Table(name = "TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private String cpf;
	//private String endereco;
	private String email;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="idEndereco")
	private Endereco endereco;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String email) throws ClienteInvalidoException {
		
		this();
		
		if(nome == null){
			throw new ClienteInvalidoException("O nome do cliente deve ser prenchido!");
		}
		if(cpf == null){
			throw new ClienteInvalidoException("O cpf do cliente deve ser prenchido!");
		}
//		if(endereco == null){
//			throw new ClienteInvalidoException("O endereco do cliente deve ser prenchido!");
//		}
		if(email == null){
			throw new ClienteInvalidoException("O e-mail do cliente deve ser prenchido!");
		}

		this.nome = nome;
		this.cpf = cpf;
		//this.endereco = endereco;
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(endereco);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
//	public String getEndereco() {
//		return endereco;
//	}
	public String getEmail() {
		return email;
	}
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

//	public void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
}

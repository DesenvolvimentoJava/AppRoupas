package br.edu.infnet.approupas.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TUsuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String senha;
	private String email;
	private String tel;
	private String tipo;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String email, String senha) {
		this();
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.setNome(nome);
	}
	
	
	@Override
	public String toString() {
		return String.format("O usuário %s - %s tem o email %s -  telefone: %s e tipo %s. ",
				nome,
				sobrenome,
				email,
				tel,
				tipo
				);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	
	
}

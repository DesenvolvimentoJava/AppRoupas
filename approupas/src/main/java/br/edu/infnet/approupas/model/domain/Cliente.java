package br.edu.infnet.approupas.model.domain;

import br.edu.infnet.approupas.model.exceptions.ClienteInvalidoException;

public class Cliente {
	
	private Integer Id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	
	public Cliente(String nome, String cpf, String endereco, String email) throws ClienteInvalidoException {
		
		if(nome == null){
			throw new ClienteInvalidoException("O nome do cliente deve ser prenchido!");
		}
		if(cpf == null){
			throw new ClienteInvalidoException("O cpf do cliente deve ser prenchido!");
		}
		if(endereco == null){
			throw new ClienteInvalidoException("O endereco do cliente deve ser prenchido!");
		}
		if(email == null){
			throw new ClienteInvalidoException("O e-mail do cliente deve ser prenchido!");
		}

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
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
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	
	
	
}

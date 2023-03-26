package br.edu.infnet.approupas.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.approupas.model.exceptions.CompraSemClienteException;
import br.edu.infnet.approupas.model.exceptions.CompraSemRoupasException;

public class Compra {
	
	private static int sequence = 1;
	
	private int id_compra;
	private String descricao;
	private boolean varejo;
	private LocalDateTime data;
	private Cliente cliente;
	private List<Roupa> roupas;
	
	
	public Compra(Cliente cliente, List<Roupa> roupas) throws CompraSemClienteException, CompraSemRoupasException {
		
		if(cliente == null) {
			throw new CompraSemClienteException("Não Existe nenhum cliente associado a compra!!!");
		}
		if(roupas == null) {
			throw new CompraSemRoupasException("Não Existe nenhuma roupa associada a compra!!!");
		}
		
		
		this.cliente = cliente;
		this.roupas = roupas;
		data = LocalDateTime.now();
		this.id_compra = sequence++;
	}
	
	public void imprimir() {
		System.out.println("Pedido: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Qtde Produtos: " + roupas.size());
		System.out.println("Roupas: ");
		
		for(Roupa produto : roupas) {
			System.out.println(" - " + produto.getDescricao());
		}
		
	}
	
	public String obterLinha() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		
		return this.getData().format(formato) +";"+
				this.getDescricao()+";"+ 
				this.getCliente().getNome() +";"+ 
				this.getCliente().getEmail() +";"+ 
				this.getRoupas().size() +"\r\n";
	}
	
	public static int getSequence() {
		return sequence;
	}

	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				
		return String.format("%s;%s;%s;%s",
				id_compra,
				descricao,
				varejo ? "Varejo" : "Atacado",
				data.format(formato)
				);
	}
		

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isLoja() {
		return varejo;
	}
	public void setLoja(boolean loja) {
		this.varejo = loja;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Roupa> getRoupas() {
		return roupas;
	}
	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	
	
	
	
	
	

}

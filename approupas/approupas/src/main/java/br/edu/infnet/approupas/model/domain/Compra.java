package br.edu.infnet.approupas.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.approupas.model.exceptions.CompraSemClienteException;
import br.edu.infnet.approupas.model.exceptions.CompraSemRoupasException;

@Entity
@Table(name = "TCompra")
public class Compra {
	
	private static int sequence = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private boolean varejo;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Roupa> roupas;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	
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
				id,
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isVarejo() {
		return varejo;
	}


	public void setVarejo(boolean varejo) {
		this.varejo = varejo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
	
	
	
	

}

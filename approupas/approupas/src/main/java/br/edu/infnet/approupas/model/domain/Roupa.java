package br.edu.infnet.approupas.model.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.approupas.model.exceptions.AnoColecaoInvalidaException;
import br.edu.infnet.approupas.model.exceptions.PorcentagemAlgodaoException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

@Entity
@Table(name = "TRoupa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Roupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private int codProd;
	private String descricao;
	private float valorCusto;
	private int qtdade;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "roupas")
	private List<Compra> compras;
	
	private final int TIPO_COMPRA = 12;
	private final float MARKUP_VAREJO = (float) 2.5;
	private final float MARKUP_ATACADO = (float) 1.9;
	
	public Roupa() {
		// TODO Auto-generated constructor stub
	}
	
	public Roupa(int cod_prod, String descricao, float valor, int quantidade) throws ValoresException, QuantidadeException {
		
		if(valor <= 0 ) {
			throw new ValoresException("Valor Invalido");
		}
		
		if(quantidade <= 0 ) {
			throw new QuantidadeException("Quantidade Invalida");
		}
		
		this.codProd = cod_prod;
		this.descricao = descricao;
		this.valorCusto = valor;
		this.qtdade = quantidade;
	}
	
	public abstract float calcularValorRoupa() throws PorcentagemAlgodaoException, AnoColecaoInvalidaException, Exception;
	
	public String obterTipoCompra() {
		return (getQtdade() < TIPO_COMPRA) ? "Varejo" : "Atacado";
	}
	
	public float obterTipoValorCompra() {
		float vlProduto = 0;
		if(getQtdade() < TIPO_COMPRA) {
			vlProduto =  getQtdade() * (getValorCusto() * MARKUP_VAREJO);
		} else {
			vlProduto = getQtdade() * (getValorCusto() * MARKUP_ATACADO);
		}
		return vlProduto;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(codProd);
		sb.append(";");
		sb.append(descricao);
		sb.append(";");
		sb.append(valorCusto);
		sb.append(";");
		sb.append(qtdade);
	
		return sb.toString();
	}

	public int getCodProd() {
		return codProd;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValorCusto() {
		return valorCusto;
	}

	public int getQtdade() {
		return qtdade;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorCusto(float valorCusto) {
		this.valorCusto = valorCusto;
	}

	public void setQtdade(int qtdade) {
		this.qtdade = qtdade;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
	
}

package br.edu.infnet.approupas.model.domain;

import br.edu.infnet.approupas.model.exceptions.PorcentagemAlgodaoException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class Masculina extends Roupa {
	
	private Integer Id;
	private boolean bordado;
	private String tamanho;
	private int porAlgodao;
	
	
	public Masculina(int cod_prod, String descricao, float valor, int quantidade) throws ValoresException, QuantidadeException {
		super(cod_prod, descricao, valor, quantidade);
	}
	
	
	private float calcularValorBordado() {
		return (float) (bordado ? getQtdade() * 0.5 : getQtdade() * 0.2);
	}
	
	private int calcularPorcentagemAlgodao() throws PorcentagemAlgodaoException {
		if(porAlgodao < 0) {
			throw new PorcentagemAlgodaoException("Porcentagem MENOR que '0'");
		}
		if (porAlgodao > 100) {
			throw new PorcentagemAlgodaoException("Porgentagem MAIOR que '100'");
		}	
		return porAlgodao * 2 ;
	}
	
	@Override
	public float calcularValorRoupa() throws PorcentagemAlgodaoException {
		return super.obterTipoValorCompra() + 
				calcularPorcentagemAlgodao() + calcularValorBordado();
	}


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(bordado ? "ComBordado" : "SemBordado");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(porAlgodao);
		sb.append(";");
		sb.append(super.obterTipoCompra());
		
		return sb.toString();
	}
	
	
	public boolean isBordado() {
		return bordado;
	}
	public void setBordado(boolean bordado) {
		this.bordado = bordado;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public int getPorAlgodao() {
		return porAlgodao;
	}
	public void setPorAlgodao(int composicao) {
		this.porAlgodao = composicao;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}
	
	
	

}

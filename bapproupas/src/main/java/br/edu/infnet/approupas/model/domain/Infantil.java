package br.edu.infnet.approupas.model.domain;

import br.edu.infnet.approupas.model.exceptions.NumeracaoInfantilInvalidaException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class Infantil extends Roupa {
	
	private Integer Id;
	private boolean conjunto;
	private int numeracao; // 0 até 16
	private String cor;
	
	public Infantil(int cod_prod, String descricao, float valor, int quantidade) throws ValoresException, QuantidadeException {
		super(cod_prod, descricao, valor, quantidade);
	}
	
	private float calcularValorNumeracao() throws NumeracaoInfantilInvalidaException {
		if(numeracao < 0) {
			throw new NumeracaoInfantilInvalidaException("Digite a Nueração correta, pois esta menor que '0'");
		}
		
		if(numeracao >16) {
			throw new NumeracaoInfantilInvalidaException("Digite a Nueração correta, pois esta maior que '16'");
		}
		
		return (float) (numeracao *1.5);
	}
	
	private float calcularValorConjunto() {
		return (float) (conjunto ? getQtdade() * 0.5 : getQtdade() * 0.2);
	}
	
	@Override
	public float calcularValorRoupa() throws NumeracaoInfantilInvalidaException {
		return super.obterTipoValorCompra() + calcularValorConjunto() + calcularValorNumeracao();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(conjunto ? "Conjunto" : "Unidade");
		sb.append(";");
		sb.append(numeracao);
		sb.append(";");
		sb.append(cor);
		sb.append(";");
		sb.append(super.obterTipoCompra());
		
		return sb.toString();
	}
	
	public boolean isConjunto() {
		return conjunto;
	}
	public void setConjunto(boolean conjunto) {
		this.conjunto = conjunto;
	}
	public int getNumeracao() {
		return numeracao;
	}
	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	
	
	

}

package br.edu.infnet.approupas.model.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.approupas.model.exceptions.AnoColecaoInvalidaException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

@Entity
@Table(name = "TFeminina")
public class Feminina extends Roupa {
	

	private boolean estampa;
	private String tamanho;
	private int colecao;
	
	public Feminina() {
		// TODO Auto-generated constructor stub
	}
	
	public Feminina(int cod_prod, String descricao, float valor, int quantidade) throws ValoresException, QuantidadeException {
		super(cod_prod, descricao, valor, quantidade);
	}
	
	
	private float cacularEstampa() {
		return (float) (estampa ? getQtdade() * 0.5 : getQtdade() * 0.2);
	}
	
	
	private int cacularAnoColecao() throws AnoColecaoInvalidaException {
		if (colecao <= 2019 && colecao >= 2022) {
			throw new AnoColecaoInvalidaException("Digite o Ano da Coleção Correta");
		}

		int ano = LocalDate.now().getYear();
		return (colecao != ano) ? getQtdade() * 2 : getQtdade() * 20; 
	}
	
	
	@Override
	public float calcularValorRoupa() throws AnoColecaoInvalidaException {
		return super.obterTipoValorCompra() + cacularAnoColecao() + cacularEstampa();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(estampa ? "Estampada" : "Lisa");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(colecao);
		sb.append(";");
		sb.append(super.obterTipoCompra());
		
		
		return sb.toString();
	}
	
	
	public boolean isEstampa() {
		return estampa;
	}
	public void setEstampa(boolean estampa) {
		this.estampa = estampa;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public int getColecao() {
		return colecao;
	}
	public void setColecao(int colecao) {
		this.colecao = colecao;
	}



	
	

}

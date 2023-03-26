package br.edu.infnet.approupas.model.tests;

import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.exceptions.PorcentagemAlgodaoException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class MasculinaTest {
	
	public static void main(String[] args) {
		
		
		try {
			Masculina m1 = new Masculina(1,"Calça", 0, 5);
			m1.setBordado(true);
			m1.setPorAlgodao(100);
			m1.setTamanho("P");
			System.out.println(m1);
			System.out.println("Valor Total: R$" + m1.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | PorcentagemAlgodaoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}

		try {
			Masculina m2 = new Masculina(12,"Camisa", 52, 0);
			m2.setBordado(true);
			m2.setPorAlgodao(67);
			m2.setTamanho("G");
			System.out.println(m2);
			System.out.println("Valor Total: R$" + m2.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | PorcentagemAlgodaoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
		try { 
			Masculina m3 = new Masculina(123,"Calça", 24, 5);
			m3.setBordado(false);
			m3.setPorAlgodao(200);
			m3.setTamanho("M");
			System.out.println(m3);
			System.out.println("Valor Total: R$" + m3.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | PorcentagemAlgodaoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
	}

}

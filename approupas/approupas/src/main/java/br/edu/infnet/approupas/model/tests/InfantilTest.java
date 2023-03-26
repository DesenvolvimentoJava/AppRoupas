package br.edu.infnet.approupas.model.tests;

import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.exceptions.NumeracaoInfantilInvalidaException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class InfantilTest {
	
	public static void main(String[] args) {
		
		
		
		try {
			Infantil i1 = new Infantil(123456, "Camisa", 35, 13);
			i1.setConjunto(true);
			i1.setCor("branco");
			i1.setNumeracao(4);
			System.out.println(i1);
			System.out.println("Valor Total: R$" + i1.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | NumeracaoInfantilInvalidaException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}

		try {
			Infantil i2 = new Infantil(123456, "Moletom", 35, 11);
			i2.setConjunto(true);
			i2.setCor("azul");
			i2.setNumeracao(2);
			System.out.println(i2);
			System.out.println("Valor Total: R$" + i2.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | NumeracaoInfantilInvalidaException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
			
		try {
			Infantil i3 = new Infantil(123456, "Calça", 75, 1);
			i3.setConjunto(false);
			i3.setCor("preta");
			i3.setNumeracao(6);
			System.out.println(i3);
			System.out.println("Valor Total: R$" + i3.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | NumeracaoInfantilInvalidaException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}	
		
		
		
		
	}

}

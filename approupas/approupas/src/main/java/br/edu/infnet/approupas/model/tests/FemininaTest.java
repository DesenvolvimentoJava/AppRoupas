package br.edu.infnet.approupas.model.tests;

import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.exceptions.AnoColecaoInvalidaException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class FemininaTest {
	
	public static void main(String[] args) {
		
		
		try {
			Feminina f1 = new Feminina(122, "Saia", 73, 3);
			f1.setColecao(2021);
			f1.setEstampa(false);
			f1.setTamanho("38");
			System.out.println(f1);
			System.out.println(f1.calcularValorRoupa());
		} catch (ValoresException | QuantidadeException | AnoColecaoInvalidaException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
		try {
			Feminina f2 = new Feminina(122, "Calça", 130, 3);
			f2.setColecao(2022);
			f2.setEstampa(true);
			f2.setTamanho("38");
			System.out.println(f2);
		} catch (ValoresException | QuantidadeException  e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
		try {	
			Feminina f3 = new Feminina(122, "Vestido", 130, 3);
			f3.setColecao(2021);
			f3.setEstampa(true);
			f3.setTamanho("38");
			System.out.println(f3);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
			
		
		
		
	}

}

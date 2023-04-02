package br.edu.infnet.approupas.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.domain.Compra;
import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.domain.Roupa;
import br.edu.infnet.approupas.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.approupas.model.exceptions.CompraSemClienteException;
import br.edu.infnet.approupas.model.exceptions.CompraSemRoupasException;
import br.edu.infnet.approupas.model.exceptions.QuantidadeException;
import br.edu.infnet.approupas.model.exceptions.ValoresException;

public class CompraTest {

	public static void main(String[] args) {
		
		List <Roupa> pedido1 = new ArrayList<>();
		List <Roupa> pedido2 = new ArrayList<>();
		List <Roupa> pedido3 = new ArrayList<>();
		List <Roupa> pedido4 = new ArrayList<>();

		
		// ROUPAS MASCULINA 
		try {
			Masculina m1 = new Masculina(1,"Calça", 12, 5);
			m1.setBordado(true);
			m1.setPorAlgodao(100);
			m1.setTamanho("P");
			pedido2.add(m1);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		try {
			Masculina m2 = new Masculina(12,"Camisa", 52, 3);
			m2.setBordado(true);
			m2.setPorAlgodao(67);
			m2.setTamanho("G");
			pedido2.add(m2);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		try {
			Masculina m3 = new Masculina(123,"Calça", 24, 5);
			m3.setBordado(false);
			m3.setPorAlgodao(33);
			m3.setTamanho("M");
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
			
		//ROUPAS FEMENINA
		try {
			Feminina f1 = new Feminina(122, "Saia", 73, 3);
			f1.setColecao(2022);
			f1.setEstampa(false);
			f1.setTamanho("38");
			pedido4.add(f1);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		try {
			Feminina f2 = new Feminina(122, "Calça", 130, 3);
			f2.setColecao(2018);
			f2.setEstampa(true);
			f2.setTamanho("38");
			pedido1.add(f2);
			pedido4.add(f2);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		try {
			Feminina f3 = new Feminina(122, "Vestido", 130, 3);
			f3.setColecao(2019);
			f3.setEstampa(true);
			f3.setTamanho("38");
			pedido2.add(f3);
			pedido4.add(f3);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		//ROUPAS INFANTIL
		try {
			Infantil i1 = new Infantil(123456, "Camisa", 35, 1);
			i1.setConjunto(true);
			i1.setCor("branco");
			i1.setNumeracao(4);
			pedido1.add(i1);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}
		
		try {
			Infantil i2 = new Infantil(123456, "Moletom", 55, 1);
			i2.setConjunto(true);
			i2.setCor("azul");
			i2.setNumeracao(2);
			pedido3.add(i2);
			pedido4.add(i2);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}	
		
		try {
			Infantil i3 = new Infantil(123456, "Calça", 75, 1);
			i3.setConjunto(false);
			i3.setCor("preta");
			i3.setNumeracao(6);
			pedido3.add(i3);
		} catch (ValoresException | QuantidadeException e) {
			System.out.println("[ ERRO ] " + e.getMessage() );
		}


		try {
			Compra comp1 = new Compra(new Cliente("huguinho", "1234567891011", "eu@huguinho.com"), pedido1);
			comp1.setDescricao("Primeira Compra");
			comp1.setLoja(false);
			comp1.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemRoupasException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
		try {
			Compra comp2 = new Compra(new Cliente("huguinho", "1234567891011", "eu@huguinho.com"), pedido2);
			comp2.setDescricao("Segunda Compra");
			comp2.setLoja(true);
//			comp2.setCliente(new Cliente("huguinho", "1234567891011", "Rua huguinho, 1", "eu@huguinho.com"));
//			comp2.setRoupas(pedido2);
			comp2.imprimir();
		} catch (ClienteInvalidoException  | CompraSemClienteException | CompraSemRoupasException e) {
				System.out.println("[ ERRO ] " + e.getMessage());
		}

		try {
			Compra comp3 = new Compra(new Cliente("joaozinho", "1234567891011", "eu@joaozinho.com"), pedido3);
			comp3.setDescricao("Terceira Compra");
			comp3.setLoja(true);
			comp3.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemRoupasException  e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}

		try {
			Compra comp4 = new Compra(new Cliente("mariazinha", "1234567891011", "eu@mariazinha.com"), null);
			comp4.setDescricao("Quartar Compra");
			comp4.setLoja(false);
			comp4.imprimir();
		} catch (ClienteInvalidoException  | CompraSemClienteException | CompraSemRoupasException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
		
		try {
			//Cliente c10 = new Cliente("mariazinha", "1234567891011", "Rua mariazinha, 3", "eu@mariazinha.com");
			
			Compra comp5 = new Compra(null, pedido4);
			comp5.setDescricao("Quartar Compra");
			comp5.setCliente(new Cliente("mariazinha", "1234567891011", "eu@mariazinha.com"));
			comp5.setLoja(false);
			comp5.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemRoupasException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
	}

}

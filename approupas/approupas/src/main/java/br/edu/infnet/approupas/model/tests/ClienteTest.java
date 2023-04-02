package br.edu.infnet.approupas.model.tests;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.exceptions.ClienteInvalidoException;

public class ClienteTest {
	
	public static void main(String[] args) {
		
		try {
			Cliente c1 = new Cliente(null,"1234567891011", "eu@huguinho.com");
			System.out.println(c1);
		}catch (ClienteInvalidoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
			
		try {	
			Cliente c2 = new Cliente("joaozinho",null, null);
			System.out.println(c2);
		}catch (ClienteInvalidoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}	
		
		try {	
			Cliente c3 = new Cliente("mariazinha","1234567891011", "eu@mariazinha.com");
			System.out.println(c3);
		}catch (ClienteInvalidoException e) {
			System.out.println("[ ERRO ] " + e.getMessage());
		}
	}

}

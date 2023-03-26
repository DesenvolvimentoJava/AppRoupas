package br.edu.infnet.approupas.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class AquivoTest {
	
	public static void main(String[] args) {
		
		String arq = "compra.txt";
	

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			FileWriter fileW = new FileWriter("out_"+arq);
			BufferedWriter escrita = new BufferedWriter(fileW);
			
			String linha = leitura.readLine();
			String[] campos = null;
			
			List <Roupa> pedido = new ArrayList<>();
			Compra compra = null;
			
			while(linha != null) {
				
				campos = linha.split(";");
				
				switch (campos[0].toUpperCase()) {
				case "C":
					try {
						compra = new Compra(new Cliente(campos[3], campos[6],campos[4],campos[5]), pedido);
						compra.setDescricao(campos[1]);
						compra.setLoja(Boolean.valueOf(campos[2]));
					} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemRoupasException  e) {
						System.out.println("[ ERRO ] " + e.getMessage());
					}	
					break;
				case "M":
					try {
						Masculina masculina = new Masculina(Integer.valueOf(campos[1]),campos[2], Float.valueOf(campos[3]),Integer.valueOf(campos[4]));
						masculina.setBordado(Boolean.valueOf(campos[5]));
						masculina.setPorAlgodao(Integer.valueOf(campos[6]));
						masculina.setTamanho(campos[7]);
						pedido.add(masculina);
					} catch (ValoresException | QuantidadeException e) {
					System.out.println("[ ERRO ] " + e.getMessage() );
					}
					break;
				case "F":
					try {
						Feminina feminina = new Feminina(Integer.valueOf(campos[1]),campos[2], Float.valueOf(campos[3]),Integer.valueOf(campos[4]));
						feminina.setColecao(Integer.valueOf(campos[5]));
						feminina.setEstampa(Boolean.valueOf(campos[6]));
						feminina.setTamanho(campos[7]);
						pedido.add(feminina);;
					} catch (ValoresException | QuantidadeException e) {
						System.out.println("[ ERRO ] " + e.getMessage() );
					}
					break;
				case "I":
					try {
						Infantil infantil = new Infantil(Integer.valueOf(campos[1]),campos[2], Float.valueOf(campos[3]),Integer.valueOf(campos[4]));
						infantil.setConjunto(Boolean.valueOf(campos[5]));
						infantil.setCor(campos[6]);
						infantil.setNumeracao(Integer.valueOf(campos[7]));
						pedido.add(infantil);
					} catch (ValoresException | QuantidadeException e) {
						System.out.println("[ ERRO ] " + e.getMessage() );
					}
					break;
				default:
					break;
			
				}
				
				linha = leitura.readLine();
				
			}
			
			System.out.println("Arquivo Execultado C/ Sucesso!!!");
			
			escrita.write(compra.obterLinha());
			
			escrita.close();			
			leitura.close();
			fileR.close();
		} catch (IOException e) {
			System.out.println("");
		}
		
	}

}

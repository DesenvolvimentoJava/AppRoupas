package br.edu.infnet.approupas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.service.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner{
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String arq = "cliente.txt";
		

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			
			String linha = leitura.readLine();
			String[] clientes = null;
			
			
			while(linha != null) {
				
				clientes = linha.split(";");
				
				
				Cliente cliente = new Cliente(
						clientes[0], 
						clientes[1], 
						clientes[2], 
						clientes[3]);
		
				
				clienteService.incluir(cliente);				
				
				linha = leitura.readLine();
				
			}
			
			System.out.println("Arquivo Execultado C/ Sucesso!!!");
			
					
			leitura.close();
			fileR.close();
		} catch (IOException e) {
			System.out.println("");
		}
		
	}

				

}

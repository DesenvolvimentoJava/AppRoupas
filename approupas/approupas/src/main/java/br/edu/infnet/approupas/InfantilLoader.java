package br.edu.infnet.approupas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.InfantilService;


@Order(5)
@Component
public class InfantilLoader implements ApplicationRunner{
	
	@Autowired
	private InfantilService infantilService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String arq = "infantil.txt";
		Usuario admin = new Usuario();
		admin.setId(1);

		

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			
			String linha = leitura.readLine();
			String[] infantis = null;
			
			
			while(linha != null) {
				
				infantis = linha.split(";");
				
				
				Infantil infantil = new Infantil(Integer.valueOf(infantis[0]), infantis[1],Float.valueOf(infantis[2]), Integer.valueOf(infantis[3]));
				infantil.setConjunto(Boolean.valueOf(infantis[4]));
				infantil.setNumeracao(Integer.valueOf(infantis[5]));
				infantil.setCor(infantis[6]);
				infantil.setUsuario(admin);
				
				
				infantilService.incluir(infantil);				
				
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

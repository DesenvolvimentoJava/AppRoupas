package br.edu.infnet.approupas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.FemininaService;

@Order(3)
@Component
public class FemininaLoader implements ApplicationRunner{
	
	@Autowired
	private FemininaService femininaService;

	/**
	 *
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String arq = "feminina.txt";
		
		Usuario admin = new Usuario();
		admin.setId(1);

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			
			String linha = leitura.readLine();
			String[] femininas = null;
			
			
			while(linha != null) {
				
				femininas = linha.split(";");
				
				
				Feminina feminina = new Feminina(Integer.valueOf(femininas[0]), femininas[1],Float.valueOf(femininas[2]), Integer.valueOf(femininas[3]));
				feminina.setEstampa(Boolean.valueOf(femininas[4]));
				feminina.setTamanho(femininas[5]);
				feminina.setColecao(Integer.valueOf(femininas[6]));
				feminina.setUsuario(admin);
				
				femininaService.incluir(feminina);
						
				
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

package br.edu.infnet.approupas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.MasculinaService;


@Order(4)
@Component
public class MasculinaLoader implements ApplicationRunner{
	
	@Autowired
	private MasculinaService masculinaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String arq = "masculina.txt";
		Usuario admin = new Usuario();
		admin.setId(1);
		

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			
			String linha = leitura.readLine();
			String[] masculinas = null;
			
			
			while(linha != null) {
				
				masculinas = linha.split(";");
				
				Masculina masculina = new Masculina(Integer.valueOf(masculinas[0]), masculinas[1],Float.valueOf(masculinas[2]), Integer.valueOf(masculinas[3]));
				masculina.setBordado(Boolean.valueOf(masculinas[4]));
				masculina.setTamanho(masculinas[5]);
				masculina.setPorAlgodao(Integer.valueOf(masculinas[6]));
				masculina.setUsuario(admin);
				
				
						
		
				
				masculinaService.incluir(masculina);				
				
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

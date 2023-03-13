package br.edu.infnet.approupas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
String arq = "usuario.txt";
		

		try {
			FileReader fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			
			String linha = leitura.readLine();
			String[] usuarios = null;
			
			
			while(linha != null) {
				
				usuarios = linha.split(";");
				
				Usuario usuario = new Usuario(usuarios[0], usuarios[2], usuarios[3]);
				usuario.setSobrenome(usuarios[1]);
				usuario.setTel(usuarios[4]);
				usuario.setTipo(usuarios[5]);
				
				usuarioService.incluir(usuario);
				
								
				
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

package br.edu.infnet.approupas.model.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Usuario;


@Repository
public class UUsuarioRepository {
		
	private static Integer id = 1;
	
	private static Map<Integer, Usuario> mapaUsuario = new HashMap<>();
	
	
	
	public boolean incluir(Usuario usuario) {
		
		usuario.setId(id++);
		
		try {
			mapaUsuario.put(usuario.getId(), usuario);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Usuario excluir(Integer key) {
		return mapaUsuario.remove(key);
	}
	
	
	public Collection<Usuario> obterLista(){
		
		return mapaUsuario.values();
	}
}

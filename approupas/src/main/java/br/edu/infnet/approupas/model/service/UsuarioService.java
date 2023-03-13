package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	
	public boolean incluir(Usuario usuario) {
		return usuarioRepository.incluir(usuario);
		
	}
	
	
	
	public Usuario excluir(Integer key) {
		return usuarioRepository.excluir(key);
	}
	
	
	
	public Collection<Usuario> obterLista(){
		
		return usuarioRepository.obterLista();
	}

}

package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha(), Sort.by(Direction.ASC, "nome"));
	}
	

	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	
	
	public void excluir(Integer key) {
		usuarioRepository.deleteById(key);
	}
	
	
	
	public Collection<Usuario> obterLista(){
		
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

}

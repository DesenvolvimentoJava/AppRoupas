package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.InfantilRepository;

@Service
public class InfantilService {
	
	@Autowired
	public InfantilRepository infantilRepository;
	
	
	public Infantil incluir(Infantil infantil) {
		return infantilRepository.save(infantil);
		
	}
	
	
	
	public void excluir(Integer id) {
		infantilRepository.deleteById(id);
	}
	
	
	
	public Collection<Infantil> obterLista(){
		
		return (Collection<Infantil>) infantilRepository.findAll();
	}
	
	public Collection<Infantil> obterLista(Usuario usuario){
		
		return (Collection<Infantil>) infantilRepository.ObterLista(usuario.getId());
	}
	
	public Infantil obterPorId(Integer id) {
		return infantilRepository.findById(id).orElse(null);
	}
}

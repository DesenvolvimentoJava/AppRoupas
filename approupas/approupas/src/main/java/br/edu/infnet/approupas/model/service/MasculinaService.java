package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.MasculinaRepository;

@Service
public class MasculinaService {
	
	@Autowired
	public MasculinaRepository masculinaRepository;
	
	
	public Masculina incluir(Masculina masculina) {
		return masculinaRepository.save(masculina);
		
	}
	
	
	
	public void excluir(Integer id) {
		masculinaRepository.deleteById(id);
	}
	
	
	
	public Collection<Masculina> obterLista(){
		
		return (Collection<Masculina>) masculinaRepository.findAll();
	}
	
	public Collection<Masculina> obterLista(Usuario usuario){
		
		return (Collection<Masculina>) masculinaRepository.ObterLista(usuario.getId());
	}
	
	public Masculina obterPorId(Integer id) {
		return masculinaRepository.findById(id).orElse(null);
	}
}

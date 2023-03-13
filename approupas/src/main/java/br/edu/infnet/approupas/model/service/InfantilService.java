package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.repository.InfantilRepository;

@Service
public class InfantilService {
	
	@Autowired
	public InfantilRepository infantilRepository;
	
	
	public boolean incluir(Infantil infantil) {
		return infantilRepository.incluir(infantil);
		
	}
	
	
	
	public Infantil excluir(Integer key) {
		return infantilRepository.excluir(key);
	}
	
	
	
	public Collection<Infantil> obterLista(){
		
		return infantilRepository.obterLista();
	}

}

package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.repository.MasculinaRepository;

@Service
public class MasculinaService {
	
	@Autowired
	public MasculinaRepository masculinaRepository;
	
	
	public boolean incluir(Masculina masculina) {
		return masculinaRepository.incluir(masculina);
		
	}
	
	
	
	public Masculina excluir(Integer key) {
		return masculinaRepository.excluir(key);
	}
	
	
	
	public Collection<Masculina> obterLista(){
		
		return masculinaRepository.obterLista();
	}

}

package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.repository.FemininaRepository;

@Service
public class FemininaService {
	
	@Autowired
	public FemininaRepository femininaRepository;
	
	
	public boolean incluir(Feminina feminina) {
		return femininaRepository.incluir(feminina);
		
	}
	
	
	
	public Feminina excluir(Integer key) {
		return femininaRepository.excluir(key);
	}
	
	
	
	public Collection<Feminina> obterLista(){
		
		return femininaRepository.obterLista();
	}

}

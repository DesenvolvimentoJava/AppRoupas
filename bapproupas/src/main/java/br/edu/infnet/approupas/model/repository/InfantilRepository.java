package br.edu.infnet.approupas.model.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Infantil;

@Repository
public class InfantilRepository {
		
	private static Integer id = 1;
	
	private static Map<Integer, Infantil> mapaInfantil = new HashMap<>();
	
	
	
	public boolean incluir(Infantil infantil) {
		
		infantil.setId(id++);
		
		try {
			mapaInfantil.put(infantil.getId(), infantil);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Infantil excluir(Integer key) {
		return mapaInfantil.remove(key);
	}
	
	
	public Collection<Infantil> obterLista(){
		
		return mapaInfantil.values();
	}
}

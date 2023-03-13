package br.edu.infnet.approupas.model.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Masculina;

@Repository
public class MasculinaRepository {
		
	private static Integer id = 1;
	
	private static Map<Integer, Masculina> mapaMasculina = new HashMap<>();
	
	
	
	public boolean incluir(Masculina masculina) {
		
		masculina.setId(id++);
		
		try {
			mapaMasculina.put(masculina.getId(), masculina);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Masculina excluir(Integer key) {
		return mapaMasculina.remove(key);
	}
	
	
	public Collection<Masculina> obterLista(){
		
		return mapaMasculina.values();
	}
}

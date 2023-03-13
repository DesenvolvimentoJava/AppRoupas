package br.edu.infnet.approupas.model.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Feminina;

@Repository
public class FemininaRepository {
		
	private static Integer id = 1;
	
	private static Map<Integer, Feminina> mapaFeminina = new HashMap<>();
	
	
	
	public boolean incluir(Feminina feminina) {
		
		feminina.setId(id++);
		
		try {
			mapaFeminina.put(feminina.getId(), feminina);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Feminina excluir(Integer key) {
		return mapaFeminina.remove(key);
	}
	
	
	public Collection<Feminina> obterLista(){
		
		return mapaFeminina.values();
	}
}

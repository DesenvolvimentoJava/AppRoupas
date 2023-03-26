package br.edu.infnet.approupas.model.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.approupas.model.domain.Roupa;

public class RoupaRepository {
		
//	private static Integer id = 1;
	
	private static Map<Integer, Roupa> mapaRoupa = new HashMap<>();
	
	
	
//	public static boolean incluir(Roupa roupa) {
//		
//		roupa.setId(id++);
//		
//		try {
//			mapaRoupa.put(roupa).getId(), roupa);
//			return true;
//			
//		} catch (Exception e) {
//			return false;
//		}
//		
//	}
	
	public static Roupa excluir(Integer key) {
		return mapaRoupa.remove(key);
	}
	
	
	public static Collection<Roupa> obterLista(){
		
		return mapaRoupa.values();
	}
	
	
}

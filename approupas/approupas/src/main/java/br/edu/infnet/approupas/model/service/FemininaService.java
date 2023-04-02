package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.FemininaRepository;

@Service
public class FemininaService {
	
	@Autowired
	public FemininaRepository femininaRepository;
	
	
	public Feminina incluir(Feminina feminina) {
		return femininaRepository.save(feminina);
		
	}
	
	
	
	public void excluir(Integer id) {
		femininaRepository.deleteById(id);
	}
	
	
	
	public Collection<Feminina> obterLista(){
		
		return (Collection<Feminina>) femininaRepository.findAll();
	}
	
	public Collection<Feminina> obterLista(Usuario usuario){
		
		return (Collection<Feminina>) femininaRepository.ObterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
	
	public Feminina obterPorId(Integer id) {
		return femininaRepository.findById(id).orElse(null);
	}
}

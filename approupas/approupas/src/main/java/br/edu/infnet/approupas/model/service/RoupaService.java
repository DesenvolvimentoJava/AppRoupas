package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Roupa;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.RoupaRepository;

@Service
public class RoupaService {
	
	@Autowired
	public RoupaRepository roupaRepository;
	
	

	
	public void excluir(Integer id) {
		roupaRepository.deleteById(id);
	}
	
	
	
	public Collection<Roupa> obterLista(){
		
		return (Collection<Roupa>) roupaRepository.findAll();
	}
	
	public Collection<Roupa> obterLista(Usuario usuario){
		
		return (Collection<Roupa>) roupaRepository.ObterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
	
	public Roupa obterPorId(Integer id) {
		return roupaRepository.findById(id).orElse(null);
	}
}

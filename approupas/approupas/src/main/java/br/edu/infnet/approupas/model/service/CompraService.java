package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Compra;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	public CompraRepository compraRepository;
	
	
	public Compra incluir(Compra compra) {
		return compraRepository.save(compra);
		
	}
	
	
	
	public void excluir(Integer id) {
		compraRepository.deleteById(id);
	}
	
	
	
	public Collection<Compra> obterLista(){
		
		return (Collection<Compra>) compraRepository.findAll();
	}
	
	public Collection<Compra> obterLista(Usuario usuario){
		
		return (Collection<Compra>) compraRepository.ObterLista(usuario.getId( ), Sort.by(Direction.ASC, "descricao"));
	}
	
	public Compra obterPorId(Integer id) {
		return compraRepository.findById(id).orElse(null);
	}
}

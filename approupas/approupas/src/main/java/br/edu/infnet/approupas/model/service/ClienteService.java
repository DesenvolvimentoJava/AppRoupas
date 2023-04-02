package br.edu.infnet.approupas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	
	
	public void excluir(Integer key) {
		clienteRepository.deleteById(key);
	}
	
	
	
	public Collection<Cliente> obterLista(){
		
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Usuario usuario){
		
		return clienteRepository.ObterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
	}

}

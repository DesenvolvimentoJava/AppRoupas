package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.approupas.model.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
	@Query("from Cliente c where c.usuario.id = :userId")
	List<Cliente> ObterLista(Integer userId);

}

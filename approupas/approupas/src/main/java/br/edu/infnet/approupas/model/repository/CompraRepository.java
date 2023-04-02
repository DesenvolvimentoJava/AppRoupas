package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.approupas.model.domain.Compra;

public interface CompraRepository extends CrudRepository<Compra, Integer>{
	
	@Query("from Compra co where co.usuario.id = :userId")
	List<Compra> ObterLista(Integer userId, Sort sort);

}

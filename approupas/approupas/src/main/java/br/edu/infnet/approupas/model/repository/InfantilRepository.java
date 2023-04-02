package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Infantil;

@Repository
public interface InfantilRepository extends CrudRepository<Infantil, Integer> {
	
	@Query("from Infantil i where i.usuario.id = :userId")
	List<Infantil> ObterLista(Integer userId, Sort sort);

}

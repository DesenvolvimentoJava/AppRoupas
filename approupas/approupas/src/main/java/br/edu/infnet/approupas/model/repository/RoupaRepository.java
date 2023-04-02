package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer> {
	
	@Query("from Roupa r where r.usuario.id = :userId")
	List<Roupa> ObterLista(Integer userId, Sort sort);

}

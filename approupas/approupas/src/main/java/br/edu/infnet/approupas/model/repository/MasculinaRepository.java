package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Masculina;

@Repository
public interface MasculinaRepository extends CrudRepository<Masculina, Integer> {
	
	@Query("from Masculina m where m.usuario.id = :userId")
	List<Masculina> ObterLista(Integer userId);

}

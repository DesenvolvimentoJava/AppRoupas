package br.edu.infnet.approupas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.approupas.model.domain.Feminina;

@Repository
public interface FemininaRepository extends CrudRepository<Feminina, Integer> {
	
	@Query("from Feminina f where f.usuario.id = :userId")
	List<Feminina> ObterLista(Integer userId);

}

package br.edu.infnet.approupas.model.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.approupas.model.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	Usuario autenticacao(String email, String senha, Sort sort);

}

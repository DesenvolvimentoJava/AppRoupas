package br.edu.infnet.approupas.model.repository;

import br.edu.infnet.approupas.model.domain.Usuario;

public class AcessoRepository {
	
	public static Usuario autenticar(Usuario usuario) {
		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
		}

		return null;
	}

}

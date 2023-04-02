package br.edu.infnet.approupas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.approupas.clients.IEnderecoClient;
import br.edu.infnet.approupas.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco bucaPorCep(String cep) {
		
		return enderecoClient.buscaPorCep(cep);
	}

}

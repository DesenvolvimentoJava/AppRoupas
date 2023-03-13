package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.service.ClienteService;



@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	private String msg;
	
	public ClienteController() {
		
	}
	
	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}

	@GetMapping(value = "/cliente/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("cliente", clienteService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente) {

		clienteService.incluir(cliente);
		
		msg = "A inclusão do cliente " + cliente.getNome() + " foi realizada com SUCESSO!!!";
		
		System.out.println(cliente.toString());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Cliente cliente = clienteService.excluir(id);
		
		msg = "A exclusão do cliente " + cliente.getNome() + " foi realizada com SUCESSO!!!";
		
		
		return "redirect:/cliente/lista";
	}


}

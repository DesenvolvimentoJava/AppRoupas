package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.approupas.model.domain.Cliente;
import br.edu.infnet.approupas.model.domain.Usuario;
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
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("cliente", clienteService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente, @SessionAttribute("usuario") Usuario usuario) {

		cliente.setUsuario(usuario);
		clienteService.incluir(cliente);
		
		msg = "A inclusão do cliente " + cliente.getNome() + " foi realizada com SUCESSO!!!";
		
		System.out.println(cliente.toString());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		clienteService.excluir(id);
		
		msg = "A exclusão do cliente ("+id+") foi realizada com SUCESSO!!!";
		
		
		return "redirect:/cliente/lista";
	}


}

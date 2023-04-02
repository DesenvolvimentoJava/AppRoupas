package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.UsuarioService;



@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String msg;
	
	public UsuarioController() {
		
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		
		usuarioService.incluir(usuario);
		
	
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		try {
			usuarioService.excluir(id);
			
			msg = "A exclusão do usuáio ("+id+") foi realizada com SUCESSO!!!";
		} catch (Exception e) {
			msg = "Impossivel realizar a Exclusão do Usuario ("+id+")!!!";
		}
		
		
		
		return "redirect:/usuario/lista";
	}


}

package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.approupas.model.domain.Infantil;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.InfantilService;



@Controller
public class InfantilController {
	
	@Autowired
	private InfantilService infantilService;
	
	private String msg;
	
	public InfantilController() {
		
	}
	
	@GetMapping(value = "/infantil")
	public String telaCadastro() {
		return "infantil/cadastro";
	}

	@GetMapping(value = "/infantil/lista")
	public String telaLista(Model model,  @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("infantil", infantilService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "infantil/lista";
	}

	@PostMapping(value = "/infantil/incluir")
	public String incluir(Infantil infantil,  @SessionAttribute("usuario") Usuario usuario) {

		infantil.setUsuario(usuario);
		infantilService.incluir(infantil);
		
		msg = "A inclusão da roupa Infantil " + infantil.getDescricao() + " foi realizada com SUCESSO!!!";
		
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/infantil/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		infantilService.excluir(id);
		
		msg = "A exclusão da Roupa Infantil ("+id+") foi realizada com SUCESSO!!!";
		
		
		return "redirect:/infantil/lista";
	}


}

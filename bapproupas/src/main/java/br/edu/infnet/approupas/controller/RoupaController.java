package br.edu.infnet.approupas.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.approupas.model.repository.RoupaRepository;



@Controller
public class RoupaController {
	
	private String msg;
	
	public RoupaController() {
		
	}
	
	@GetMapping(value = "/roupa")
	public String telaCadastro() {
		return "roupa/cadastro";
	}

	@GetMapping(value = "/roupa/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("roupa", RoupaRepository.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "roupa/lista";
	}

//	@PostMapping(value = "/roupa/incluir")
//	public String incluir(Roupa roupa) {
//
//		RoupaRepository.incluir(roupa);
//		
//		msg = "A inclusão da Roupa " + roupa.getDescricao() + " foi realizada com SUCESSO!!!";
//		
//		System.out.println(roupa.toString());
//		
//		return "redirect:/";
//	}
	
//	@GetMapping(value = "/roupa/{id}/excluir")
//	public String excluir(@PathVariable Integer id) {
//		
//		Roupa roupa = RoupaRepository.excluir(id);
//		
//		msg = "A exclusão do Roupa " + roupa.getDescricao() + " foi realizada com SUCESSO!!!";
//		
//		
//		return "redirect:/roupa/lista";
//	}


}

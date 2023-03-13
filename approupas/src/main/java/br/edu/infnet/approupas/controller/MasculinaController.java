package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.approupas.model.domain.Masculina;
import br.edu.infnet.approupas.model.service.MasculinaService;



@Controller
public class MasculinaController {
	//
	@Autowired
	private MasculinaService masculinaService;
	
	private String msg;
	
	public MasculinaController() {
		
	}
	
	@GetMapping(value = "/masculina")
	public String telaCadastro() {
		return "masculina/cadastro";
	}

	@GetMapping(value = "/masculina/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("masculina", masculinaService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "masculina/lista";
	}

	@PostMapping(value = "/masculina/incluir")
	public String incluir(Masculina masculina) {

		masculinaService.incluir(masculina);
		
		msg = "A inclusão da Masculina " + masculina.getDescricao() + " foi realizada com SUCESSO!!!";
		
		System.out.println(masculina.toString());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/masculina/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Masculina masculina = masculinaService.excluir(id);
		
		msg = "A exclusão da Masculina " + masculina.getDescricao() + " foi realizada com SUCESSO!!!";
		
		
		return "redirect:/masculina/lista";
	}


}

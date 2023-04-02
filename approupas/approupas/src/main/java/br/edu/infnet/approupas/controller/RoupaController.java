package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.approupas.model.domain.Roupa;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.RoupaService;



@Controller
public class RoupaController {
	
	@Autowired
	private RoupaService roupaService;
	
	private String msg;
	
	public RoupaController() {
		
	}
	

	@GetMapping(value = "/roupa/lista")
	public String telaLista(Model model,  @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("roupa", roupaService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "roupa/lista";
	}


	
	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Roupa roupa = roupaService.obterPorId(id);
		
		
		try {
			roupaService.excluir(id);
			
			msg = "A exclusão da Roupa (" + roupa.getDescricao() +") foi realizada com SUCESSO!!!";
		} catch (Exception e) {
			msg = "Impossivel realizar a exclusão do produto (" + roupa.getDescricao() +") !!!";
		}
			
		
		return "redirect:/roupa/lista";
	}


}

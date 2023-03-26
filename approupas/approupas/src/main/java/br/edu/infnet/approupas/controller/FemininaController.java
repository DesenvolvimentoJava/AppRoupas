package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.approupas.model.domain.Feminina;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.FemininaService;



@Controller
public class FemininaController {
	
	@Autowired
	private FemininaService femininaService;
	
	private String msg;
	
	public FemininaController() {
		
	}
	
	@GetMapping(value = "/feminina")
	public String telaCadastro() {
		return "feminina/cadastro";
	}

	@GetMapping(value = "/feminina/lista")
	public String telaLista(Model model,  @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("feminina", femininaService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "feminina/lista";
	}

	@PostMapping(value = "/feminina/incluir")
	public String incluir(Feminina feminina,  @SessionAttribute("usuario") Usuario usuario) {

		feminina.setUsuario(usuario);
		femininaService.incluir(feminina);
		
		msg = "A inclusão do Feminina " + feminina.getDescricao() + " foi realizada com SUCESSO!!!";
		
		System.out.println(feminina.toString());
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/feminina/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		femininaService.excluir(id);
		
		msg = "A exclusão da Roupa Feminina ("+id+") foi realizada com SUCESSO!!!";
		
		
		return "redirect:/feminina/lista";
	}


}

package br.edu.infnet.approupas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.approupas.model.domain.Compra;
import br.edu.infnet.approupas.model.domain.Usuario;
import br.edu.infnet.approupas.model.service.CompraService;



@Controller
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	private String msg;
	
	public CompraController() {
		
	}
	
	@GetMapping(value = "/compra")
	public String telaCadastro() {
		return "compra/cadastro";
	}

	@GetMapping(value = "/compra/lista")
	public String telaLista(Model model,  @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("compras", compraService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "compra/lista";
	}

	@PostMapping(value = "/compra/incluir")
	public String incluir(Compra compra,  @SessionAttribute("usuario") Usuario usuario) {

		compra.setUsuario(usuario);
		compraService.incluir(compra);
		
		msg = "A inclusão da compra " + compra.getDescricao() + " foi realizada com SUCESSO!!!";
		
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/compra/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Compra compra = compraService.obterPorId(id);
		
		compraService.excluir(id);
		
		msg = "A exclusão do pedido ("+ compra.getDescricao() +") foi realizada com SUCESSO!!!";
		
		
		return "redirect:/compra/lista";
	}


}

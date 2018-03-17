package br.com.danieldias.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.danieldias.model.Pessoa;
import br.com.danieldias.persistencia.MongoDAO;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Controller
@RequestMapping("/pessoas")
public class PessoasControler {

	@Autowired
	MongoDAO dao;

	@GetMapping("/inserirPessoa.html")
	public ModelAndView cadastrar() {
		return new ModelAndView("inserirPessoa");
	}

	@GetMapping("/alterarPessoa.html/{_id}")
	public ModelAndView alterar(@PathVariable("_id") ObjectId _id) {
		return new ModelAndView("alterarPessoa","atualizar",dao.porId(_id));
	}

	@PostMapping("inserirPessoa")
	public String adicionar(Pessoa pessoa) {
		dao.inserir(pessoa);
		return "redirect:/pessoas/listaPessoa";
	}

	@GetMapping("listaPessoa")
	public String listar(Model model) {
		model.addAttribute("listas", dao.mostraTodos());
		return "lista";
	}

	@PostMapping("alterar")
	public String update(Pessoa pessoa) {
		dao.atualizar(pessoa);
		return "redirect:/pessoas/listaPessoa";
	}

	@GetMapping("remover/{_id}")
	public String deletar(@PathVariable("_id") ObjectId _id) {
		dao.excluir(_id);
		return "redirect:/pessoas/listaPessoa";
	}
}
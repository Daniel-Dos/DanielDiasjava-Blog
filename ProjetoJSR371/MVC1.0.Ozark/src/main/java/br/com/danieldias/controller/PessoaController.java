package br.com.danieldias.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.bson.types.ObjectId;

import br.com.danieldias.model.Pessoa;
import br.com.danieldias.persistencia.MongoDAO;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Controller
@Path("mvc")
public class PessoaController {

	@Inject
	Models models;

	@Inject
	MongoDAO<Pessoa> pessoaDao;

	@GET
	@Path("novo")
	public Viewable novo() {
		return new Viewable("inserir.jsp");
	}

	@GET
	@Path("mostrar")
	@View("mostrar.jsp")
	public void listar() {
	  this.models.put("listar", pessoaDao.listarTodos());
	}

	@POST
	@Path("add")
	public String adicionar(@BeanParam Pessoa pessoa) {
		pessoaDao.inserir(pessoa);

		return "redirect:mvc/mostrar";		
	}
	
	@POST
	@Path("update")
	public String atualizar(@BeanParam Pessoa pessoa) {
		pessoaDao.alterar(pessoa);
		return "redirect:mvc/mostrar";
	}
	
	@GET
	@Path("atualizar/{_id}")
	public Viewable update(@PathParam("_id") ObjectId _id) {
		this.models.put("update",pessoaDao.porId(_id));
		return new Viewable("alterar.jsp",models);
	}

	@GET
	@Path("remover/{_id}")
	public String deletar(@PathParam("_id") ObjectId _id) {
		pessoaDao.deletar(_id);
		return "redirect:mvc/mostrar";
	}
}
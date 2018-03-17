package br.com.danieldias.model;

import javax.ws.rs.FormParam;

import org.bson.types.ObjectId;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class Pessoa {

	@FormParam("_id")
	private ObjectId _id;
	
	@FormParam("nome")
	private String nome;
	
	@FormParam("idade")
	private int idade;

	@FormParam("endereco")
	private Endereco endereco;
	
	@FormParam("jugs")
	private String jugs;
	
	@FormParam("descricao")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa() {
	}
	
	public Pessoa(String nome, Endereco endereco,
			String descricao,int idade,
			String jugs) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.descricao = descricao;
		this.idade = idade;
		this.jugs = jugs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ObjectId get_id() {
		return _id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getJugs() {
		return jugs;
	}

	public void setJugs(String jugs) {
		this.jugs = jugs;
	}
}
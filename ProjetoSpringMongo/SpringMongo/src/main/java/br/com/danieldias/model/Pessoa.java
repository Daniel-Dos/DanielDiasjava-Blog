package br.com.danieldias.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class Pessoa {

	private String nome;
	private String profissao;
	private String jugs;
	private int idade;
	private Endereco endereco;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataNascimento;

	public Pessoa() {
		this("","","",0,null,null);
	}

	public Pessoa(String nome, String profissao, 
		      String jugs, int idade, 
		      Endereco endereco,Calendar dataNascimento) {
		this.nome = nome;
		this.profissao = profissao;
		this.jugs = jugs;
		this.idade = idade;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getJugs() {
		return jugs;
	}

	public void setJugs(String jugs) {
		this.jugs = jugs;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
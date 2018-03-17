package br.com.danieldias.model;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class Endereco {

	private String cidade;
	private String bairro;
	private String estado;

	public Endereco() {
		this("","","");
	}

	public Endereco(String cidade, String bairro, String estado) {
		this.setCidade(cidade);
		this.setBairro(bairro);
		this.setEstado(estado);
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
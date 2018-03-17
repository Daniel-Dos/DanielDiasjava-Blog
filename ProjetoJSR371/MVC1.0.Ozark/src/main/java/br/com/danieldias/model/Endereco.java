package br.com.danieldias.model;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class Endereco {

	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Endereco() {
	}

	public Endereco(String estado) {
		super();
		this.estado = estado;
	}
}
package br.org.soujava.rio.vertx.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;

    private String palestrante;

    public Evento() { }

    public Evento(String titulo, String descricao, String palestrante) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.palestrante = palestrante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }


    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", palestrante=" + palestrante
                + "]";
    }
}
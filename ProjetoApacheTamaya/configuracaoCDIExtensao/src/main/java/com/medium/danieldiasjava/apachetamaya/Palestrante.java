package com.medium.danieldiasjava.apachetamaya;

import org.apache.tamaya.inject.api.Config;

public class Palestrante {

    @Config(key = "primeiro.nome")
    private String nome;

    @Config(key = "ultimo.nome")
    private String sobrenome;

    @Config(key = "titulo.palestra")
    private String tema;

    @Config(key = "descricao.palestra")
    private String descricao;

    public Palestrante() { }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTema() {
        return tema;
    }

    public String getDescricao() {
        return descricao;
    }
}
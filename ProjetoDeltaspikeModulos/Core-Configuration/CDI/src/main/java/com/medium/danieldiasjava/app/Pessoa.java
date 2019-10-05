package com.medium.danieldiasjava.app;

import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.ConfigProperty;

public class Pessoa {

    @Inject
    @ConfigProperty(name="meu.nome")
    private String nome;

    @Inject
    @ConfigProperty(name="minha.idade")
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
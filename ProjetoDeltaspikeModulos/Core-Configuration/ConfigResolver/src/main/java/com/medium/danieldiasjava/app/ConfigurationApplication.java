package com.medium.danieldiasjava.app;

import java.util.List;

import org.apache.deltaspike.core.api.config.ConfigResolver;

public class ConfigurationApplication {
    public static void main(String[] args) {

        String nome = ConfigResolver.getPropertyValue("meu.nome");

        int idade = ConfigResolver.resolve("minha.idade")
                                  .as(Integer.class)
                                  .getValue();
        
        List<String> minhasPalestras = ConfigResolver.resolve("minhas.palestras")
                                                     .as(String.class)
                                                     .asList()
                                                     .getValue();

        System.out.println("Olá ".concat(nome)
                                 .concat(" sua idade é: ") 
                                 + idade + 
                                 " e fez as seguintes palestras :" + minhasPalestras);
        
        minhasPalestras.stream().forEach(System.out::println);
    }
}
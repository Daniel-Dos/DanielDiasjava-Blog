package com.medium.danieldiasjava.apachetamaya;

import java.io.IOException;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {
    public static void main(String[] args) throws IOException {

        try (SeContainer containerInitializer = SeContainerInitializer.newInstance().initialize();){
            
            Palestrante palestrante = containerInitializer.select(Palestrante.class).get();

            StringBuilder sb = new StringBuilder();

            System.out.println("======Minha Palestra======");
            System.out.println(sb.append("Palestrante: ")
                                 .append(palestrante.getNome())
                                 .append(" ")
                                 .append(palestrante.getSobrenome())
                                 .append("\nTema: ")
                                 .append(palestrante.getTema())
                                 .append("\nDescrição: ")
                                 .append(palestrante.getDescricao()));
            System.out.println("======Fim da Minha Palestra======");
        }
    }
}
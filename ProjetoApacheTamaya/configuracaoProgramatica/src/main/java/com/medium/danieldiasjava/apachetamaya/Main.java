package com.medium.danieldiasjava.apachetamaya;

import org.apache.tamaya.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = Configuration.current();
        StringBuilder sb = new StringBuilder();
        
        System.out.println("======Minha Palestra======");
        System.out.println(sb.append("Palestrante: ")
                             .append(config.get("primeiro.nome"))
                             .append(" ")
                             .append(config.get("ultimo.nome"))
                             .append("\nTema: ").append(config.get("titulo.palestra"))
                             .append("\nDescrição: ").append(config.get("descricao.palestra")));
        System.out.println("======Fim da Minha Palestra======");
        
    }
}
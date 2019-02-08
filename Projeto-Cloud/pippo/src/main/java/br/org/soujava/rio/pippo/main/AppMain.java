package br.org.soujava.rio.pippo.main;

import java.util.Optional;

import ro.pippo.core.Pippo;

public class AppMain {
    public static Optional<String> port = Optional.ofNullable(System.getenv("PORT"));

    public static void main(String[] args) {

        Pippo pippo = new Pippo(new EventApplication());

        pippo.getServer().getSettings().contextPath("/api");
        pippo.start(Integer.parseInt(port.orElse("8080")));
    }
}
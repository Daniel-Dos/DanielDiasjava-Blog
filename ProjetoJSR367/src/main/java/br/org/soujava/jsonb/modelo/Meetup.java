package br.org.soujava.jsonb.modelo;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

public class Meetup {

    @JsonbProperty("palestrante")
    private String nomePalestrante;

    private String miniBio;
 
    private String tituloPalestra;

    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataEvento;

    public Meetup(String nomePalestrante, String miniBio, String tituloPalestra, LocalDate dataEvento) {
        super();
        this.nomePalestrante = nomePalestrante;
        this.miniBio = miniBio;
        this.tituloPalestra = tituloPalestra;
        this.dataEvento = dataEvento;
    }

    public Meetup() {}

    public String getNomePalestrante() {
        return nomePalestrante;
    }

    public void setNomePalestrante(String nomePalestrante) {
        this.nomePalestrante = nomePalestrante;
    }

    public String getMiniBio() {
        return miniBio;
    }

    public void setMiniBio(String miniBio) {
        this.miniBio = miniBio;
    }

    public String getTituloPalestra() {
        return tituloPalestra;
    }

    public void setTituloPalestra(String tituloPalestra) {
        this.tituloPalestra = tituloPalestra;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Override
    public String toString() {
        return "meetup [nomePalestrante=" + nomePalestrante + ", miniBio=" + miniBio + ", tituloPalestra="
                + tituloPalestra + ", dataEvento=" + dataEvento + "]";
    }
}

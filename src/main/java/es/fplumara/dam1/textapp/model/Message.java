package es.fplumara.dam1.textapp.model;

import es.fplumara.dam1.textapp.files.TextStore;

import java.util.List;

public class Message{

    String texto;

    String timestampp;

    Integer numeroPalabras;

    List<String> palabras = List.of(texto.split(""));

    public String getTexto() {
        return texto;
    }

    public String getTimestampp() {
        return timestampp;
    }

    public Integer getNumeroPalabras() {
        return numeroPalabras;
    }

}

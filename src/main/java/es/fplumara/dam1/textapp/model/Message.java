package es.fplumara.dam1.textapp.model;

import java.util.List;

public class Message {

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

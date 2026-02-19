package es.fplumara.dam1.textapp.model;

import es.fplumara.dam1.textapp.files.TextStore;

import java.time.LocalDate;
import java.util.List;

public class Message{

    String texto;
    LocalDate timestamp;
    Integer numeroPalabras;

    public Message(LocalDate timestamp, Integer numeroPalabras, String texto) {
        timestamp = LocalDate.now();
        this.timestamp = timestamp;
        this.numeroPalabras = numeroPalabras;
        this.texto = texto;
    }

    public String getText() {
        return texto;
    }

    public LocalDate getTimestampp() {
        return timestamp;
    }

    public Integer getNumeroPalabras() {
        return numeroPalabras;
    }

}

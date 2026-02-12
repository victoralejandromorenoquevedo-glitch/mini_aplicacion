package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.model.Message;

public interface TextStore {

    void save(Message mensaje);

    String readAll();

    String readLast(Integer ultimasLineasOFilas);
    
}

package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.model.Message;

import java.io.IOException;

public interface TextStore {

    void save(Message mensaje) throws IOException;

    String readAll() throws IOException;

    String readLast(Integer ultimasLineas);
    
}

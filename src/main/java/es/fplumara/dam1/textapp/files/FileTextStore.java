package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
import es.fplumara.dam1.textapp.exceptions.StoreException;
import es.fplumara.dam1.textapp.model.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.nio.file.*;

public class FileTextStore implements TextStore{

    AppConfig appConfig;

    public FileTextStore(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void save(Message mensaje){
        try {
            List<Object> mensajes = List.of(mensaje.getTimestampp() + " | " + mensaje.getNumeroPalabras() + " | " + mensaje.getTexto());
            Path path = Path.of(appConfig.getMessagesFile());
            if (mensaje.getTexto().length() <= appConfig.getMaxLength()) {
                Files.write(path, mensaje.getTexto().getBytes());
            } else {
                Files.write(path, mensaje.getTexto().substring(0, 199).getBytes());
            }
        }catch(IOException e){
            throw new StoreException("Error de escritura del fichero");
        }
    }

    @Override
    public String readAll(){
        try {
            Path path = Path.of(appConfig.getMessagesFile());
            if (Files.readString(path).isEmpty())
                return "";
            else {
                return Files.readString(path);
            }
        }catch (IOException e){
            throw new StoreException("Error de lectura del fichero");
        }
    }

    @Override
    public String readLast(Integer ultimasLineas) {
        try {
            Path path = Path.of(appConfig.getMessagesFile());
            List<String> lineas = List.of(Files.readString(path).split("\\R"));
            List<String> lineasDeseadas = lineas.subList(ultimasLineas, lineas.size());
            return lineasDeseadas.toString();
        }catch (IOException e){
            throw new StoreException("Error de lectura del fichero");
        }
    }

}

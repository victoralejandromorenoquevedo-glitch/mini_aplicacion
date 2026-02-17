package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
import es.fplumara.dam1.textapp.exceptions.StoreException;
import es.fplumara.dam1.textapp.model.Message;
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
            Path path = Path.of(appConfig.getMessagesFile());
            if (mensaje.getTexto().length() <= appConfig.getMaxLength()) {
                List<String> lineas = List.of(mensaje.getTexto().split("\\R"));
                for (i = 0, i<= lineas.size(), i++){

                }
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
            throw new RuntimeException("Error de lectura del fichero");
        }
    }

    @Override
    public String readLast(Integer ultimasLineasOFilas) {

    }

}

package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
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
    public void save(Message mensaje) {
        Path path = Path.of(appConfig.getMessagesFile());

        List<String> lineas = List.of(
                "RESUMEN DE LOGS",
                "--------------",
                "Total errores: 3"
        );

        Files.write(path, lineas);
    }


    @Override
    public String readAll() throws IOException {
        Path path = Path.of("datos.txt");
        String contenido = Files.readString(path);
        return contenido;
    }

    @Override
    public String readLast(Integer ultimasLineasOFilas) {
        return "";
    }

}

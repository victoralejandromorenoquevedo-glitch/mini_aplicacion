package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
import es.fplumara.dam1.textapp.model.Message;

import java.io.File;
import java.util.Properties;

public class FileTextStore implements TextStore{

    AppConfig appConfig;

    public FileTextStore(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void save(Message mensaje) {

        File ficheroSalida = new File(appConfig.getMessagesFile());

        if (ficheroSalida.exists()){
            Properties props = new Properties();
            String messagesMaxLength = props.getProperty("messages.maxLength");
            if (ficheroSalida.length() > Integer.parseInt(String.valueOf(messagesMaxLength))){
                String textoMaximo = appConfig.getMessagesFile().substring(Integer.parseInt(String.valueOf(messagesMaxLength)));
                ficheroSalida = new File(textoMaximo);
            }
        }
    }


    @Override
    public String readAll() {
        return "";
    }

    @Override
    public String readLast(Integer ultimasLineasOFilas) {
        return "";
    }

}

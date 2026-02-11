package es.fplumara.dam1.textapp.config;

import es.fplumara.dam1.textapp.exceptions.ConfigException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.valueOf;

public class AppConfig {

    private String storeType;
    private String messagesFile;
    private String messagesMaxLength;

    public AppConfig() throws IOException {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) throw new ConfigException("No existe el recurso config.properties");
            props.load(in);
        }
        storeType = props.getProperty("store.type");
        messagesFile = props.getProperty("messages.file");
        messagesMaxLength = props.getProperty("messages.maxLength");


        System.out.println(props.getProperty("logs.enabled", "true"));

    }

    public String getStoreType () {
        return storeType;
    }

    public String getMessagesFile (){
        return messagesFile;
    }

    public Integer getMaxLength (){
        try {
            return Integer.valueOf(String.valueOf(messagesMaxLength));
        }catch(ConfigException e){
            return 0;
        }
    }

}

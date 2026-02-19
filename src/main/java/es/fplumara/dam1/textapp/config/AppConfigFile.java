package es.fplumara.dam1.textapp.config;

import es.fplumara.dam1.textapp.exceptions.ConfigException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigFile {

    private String storeType;
    private String messagesFile;
    private String messagesMaxLength;

    public AppConfigFile() {
        try {
            Properties props = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("config_txt.properties");
            props.load(in);
            storeType = props.getProperty("store.type");
            messagesFile = props.getProperty("messages.file");
            messagesMaxLength = props.getProperty("messages.maxLength");
        }catch (IOException e){
            throw new ConfigException("Error de lectura de las propiedades del fichero");
        }
    }

    public String getStoreType (){
        return storeType;
    }

    public String getMessagesFile (){
        return messagesFile;
    }

    public Integer getMaxLength (){
        if (messagesMaxLength.isEmpty()){
            return 200;
        }
        return Integer.parseInt(messagesMaxLength);
    }

}

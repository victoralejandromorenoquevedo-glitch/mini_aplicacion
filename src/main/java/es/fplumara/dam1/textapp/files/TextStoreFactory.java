package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfigCsv;
import es.fplumara.dam1.textapp.config.AppConfigFile;

public class TextStoreFactory {

    public FileTextStore createTextStore(AppConfigFile appConfigFile){
        FileTextStore fileStore = new FileTextStore(appConfigFile);
        return fileStore;
    }

    public FileTextStore createCsvStore(AppConfigCsv appConfigCsv){
        CsvTextStore csvStore = new CsvTextStore(appConfigCsv);
        return csvStore;
    }

}

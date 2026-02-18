package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
import es.fplumara.dam1.textapp.exceptions.StoreException;
import es.fplumara.dam1.textapp.model.Message;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvTextStore implements TextStore{

    AppConfig appConfig;

    @Override
    public void save(Message mensaje) {
        try {
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader("timestamp", "wordCount", "text")
                    .build();
            Path path = Path.of(appConfig.getMessagesFile());
            Writer writer = Files.newBufferedWriter(path);
            CSVPrinter printer = new CSVPrinter(writer, format);

            printer.printRecord(mensaje.getTimestampp(), mensaje.getNumeroPalabras(), mensaje.getTexto());
        } catch(IOException e) {
            throw new StoreException("Error de escritura del fichero");
        }
    }

    @Override
    public String readAll(){
        Path path = Path.of(appConfig.getMessagesFile());
        Reader reader = Files.newBufferedReader(path);
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .build();
        CSVParser parser = format.parse(reader);
        for (CSVRecord r : parser) {
            String timestamp = r.get("timestamp");
            Integer wordCount = Integer.valueOf(r.get("wordCount"));
            String text = r.get("text");
        }
    }

    @Override
    public String readLast(Integer ultimasLineas) {
        return "";
    }
}

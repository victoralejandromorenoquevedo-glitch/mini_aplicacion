package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfigCsv;
import es.fplumara.dam1.textapp.exceptions.StoreException;
import es.fplumara.dam1.textapp.model.Message;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvTextStore implements TextStore{

    AppConfigCsv appConfigCsv;

    @Override
    public void save(Message mensaje) {
        try {
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader("timestamp", "wordCount", "text")
                    .build();
            Path path = Path.of(appConfigCsv.getMessagesFile());
            Writer writer = Files.newBufferedWriter(path);
            CSVPrinter printer = new CSVPrinter(writer, format);

            printer.printRecord(mensaje.getTimestampp(), mensaje.getNumeroPalabras(), mensaje.getText());
        } catch(IOException e) {
            throw new StoreException("Error de escritura del fichero");
        }
    }

    @Override
    public String readAll(){
        try {
            Path path = Path.of(appConfigCsv.getMessagesFile());
            Reader reader = Files.newBufferedReader(path);
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setTrim(true)
                    .build();
            CSVParser parser = format.parse(reader);
            List <Message> mensajes = new ArrayList<>();
            for (CSVRecord r : parser) {
                Message mensaje = new Message(
                LocalDate.parse(r.get("timestamp")),
                Integer.parseInt(r.get("numeroPalabras")),
                r.get("texto")
                );
                mensajes.add(mensaje);
            }
            return mensajes.toString();
        }catch (IOException e){
            throw new StoreException("Error de lectura del fichero");
        }
    }

    @Override
    public String readLast(Integer ultimasLineas) {
        try {
            Path path = Path.of(appConfigCsv.getMessagesFile());
            Reader reader = Files.newBufferedReader(path);
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setTrim(true)
                    .build();
            CSVParser parser = format.parse(reader);
            List <Message> mensajes = new ArrayList<>();
            for (CSVRecord r : parser) {
                Message mensaje = new Message(
                        LocalDate.parse(r.get("timestamp")),
                        Integer.parseInt(r.get("numeroPalabras")),
                        r.get("texto")
                );
                mensajes.add(mensaje);
            }
            return mensajes.subList(ultimasLineas, mensajes.size()).toString();
        }catch (IOException e){
            throw new StoreException("Error de lectura del fichero");
        }
    }

}
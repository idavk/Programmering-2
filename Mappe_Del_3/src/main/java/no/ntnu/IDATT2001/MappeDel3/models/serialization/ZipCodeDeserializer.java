package no.ntnu.IDATT2001.MappeDel3.models.serialization;

import no.ntnu.IDATT2001.MappeDel3.models.ZipCode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Deserializer class for deserializing a file into {@code ZipCode} objects.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class ZipCodeDeserializer implements Closeable{
    // Attribute:
    private final FileInputStream inputStream;

    //Constructor:
    /**
     * The constructor for the deserializer class
     * @param inputStream
     */
    public ZipCodeDeserializer(FileInputStream inputStream) {
        Objects.requireNonNull(inputStream, "Input stream is null");
        this.inputStream = inputStream;
    }

    //Deserializer:
    /**
     * Deserializes a given file into {@code ZipCode} objects.
     * @param pathToFile File to deserialize.
     * @return {@code null} if deserialization failed.
     *          List of {@code ZipCode} objects if deserialization succeeded.
     */
    public static List<ZipCode> deserializer(File pathToFile) {
        List<ZipCode> zipCodes = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile, StandardCharsets.UTF_8));
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] fields = row.split("\t");

                if (fields.length >= 3) {
                    if (fields[0].trim().length() == 4) {
                        ZipCode zipCode = new ZipCode(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim());
                        zipCodes.add(zipCode);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zipCodes;
    }

    //Closer:
    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}

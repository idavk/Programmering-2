package no.ntnu.IDATT2001.MappeDel3.modelTests.serializationTests;

import no.ntnu.IDATT2001.MappeDel3.models.ZipCode;
import no.ntnu.IDATT2001.MappeDel3.models.serialization.ZipCodeDeserializer;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeDeserializerTest {
    @Test
    void deserialize_importFailed() {
        ZipCode zipCodeTest = new ZipCode("1267", "Trondheim", "0302", "Trondheim");
        File fileTest = new File("src/main/resources/no/ntnu/IDATT2001/MappeDel3/TestPostAdress.txt");

        assertNotEquals(List.of(zipCodeTest), ZipCodeDeserializer.deserializer(fileTest));
    }

    @Test
    public void deserialize_imports() {
        ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");
        File fileTest = new File("src/main/resources/no/ntnu/IDATT2001/MappeDel3/TestPostAdress.txt");

        assertEquals(List.of(zipCodeTest), ZipCodeDeserializer.deserializer(fileTest));
    }
}
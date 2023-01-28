package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {

    @Test
    void write() throws IOException {
        Writer writer = new Writer("testWriter.txt");
        String text = "1234234\n!@#$%^&*()_+=-0][{}\\'asd?><,./";
        writer.write(text);
        writer.close();
        File fileExpected = new File("expected.txt");
        File fileActual = new File("testWriter.txt");
        long missMatch = Files.mismatch(fileExpected.toPath(), fileActual.toPath());
        assertEquals(missMatch,-1);
    }

    @Test
    void writeException() {
        Writer writer = new Writer("testWriter");
        String text = "1234234\n!@#$%^&*()_+=-0][{}\\'asd?><,./";
        writer.write(text);
        writer.close();
        assertThrows(RuntimeException.class, () ->writer.write(text));
    }
}
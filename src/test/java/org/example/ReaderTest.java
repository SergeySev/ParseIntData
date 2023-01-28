package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void read() {
        assertAll(
                () -> assertEquals(new ArrayList<>(List.of(new String[]{"lived", "was", "dog", "", "1+1", "0", "!@#$%^&*()_'+?><|\"}{P"})), Reader.read("testRead.txt")),
                () -> assertEquals(new ArrayList<>(List.of(new String[0])), Reader.read("testRead2.txt")),
                () -> assertThrows(RuntimeException.class, () -> Reader.read("test1.txt")),
                () -> assertThrows(RuntimeException.class, () -> Reader.read("test"))

        );

    }
}
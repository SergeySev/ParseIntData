package org.example;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @org.junit.jupiter.api.Test
    void pars() {
        assertAll(
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{1})), Parser.pars("1")),
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{0})), Parser.pars("0")),
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{-1})), Parser.pars("-1")),
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{1, 2, 3})), Parser.pars("1 2 3")),
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{123})), Parser.pars("123")),
                () -> assertEquals(new ArrayList<>(List.of(new Integer[]{12, 3})), Parser.pars("12 3")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars("1a")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars("1A")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars("A")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars("a")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars("кириллица")),
                () -> assertThrows(InvalidLineException.class, () -> Parser.pars(""))
        );
    }
}
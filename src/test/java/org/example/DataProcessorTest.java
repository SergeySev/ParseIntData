package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    @Test
    void sorted() {
        List<Integer> expected = new ArrayList<>(List.of(new Integer[]{3, 2, 1}));
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{1, 2, 3})));
        assertEquals(expected, actual.sorted());
    }

    @Test
    void sortedSameElement() {
        List<Integer> expected = new ArrayList<>(List.of(new Integer[]{3, 3, 3}));
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{3, 3, 3})));
        assertEquals(expected, actual.sorted());
    }

    @Test
    void sortedEmpty() {
        List<Integer> expected = new ArrayList<>(List.of(new Integer[0]));
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[0])));
        assertEquals(expected, actual.sorted());
    }

    @Test
    void sortedOneEL() {
        List<Integer> expected = new ArrayList<>(List.of(new Integer[]{1}));
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{1})));
        assertEquals(expected, actual.sorted());
    }

    @Test
    void sortedNegative() {
        List<Integer> expected = new ArrayList<>(List.of(new Integer[]{3, 2, 1, 0, -1, -2, -3}));
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{-3, -2, -1, 0, 1, 2, 3})));
        assertEquals(expected, actual.sorted());
    }

    @Test
    void sumEven() {
        int expected = 6;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{1, 2, 1, 2, 1, 2})));
        assertEquals(expected, actual.sumEven());
    }

    @Test
    void sumEvenEmpty() {
        int expected = 0;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{1, 1, 1})));
        assertEquals(expected, actual.sumEven());
    }

    @Test
    void avgOdd() {
        int expected = 1;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{1, 2, 1, 2, 1, 2})));
        assertEquals(expected, actual.avgOdd());
    }

    @Test
    void avgOddWithoutOdd() {
        int expected = 0;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{2, 2, 2})));
        assertEquals(expected, actual.avgOdd());
    }
    @Test
    void avgOddEmpty() {
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[0])));
        assertThrows(NoSuchElementException.class, actual::max);
    }

    @Test
    void max() {
        int expected = 2;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{2, 0, -2})));
        assertEquals(expected, actual.max());
    }

    @Test
    void maxEmpty() {
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[0])));
        assertThrows(NoSuchElementException.class, actual::max);
    }

    @Test
    void min() {
        int expected = -2;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{2, 0, -2})));
        assertEquals(expected, actual.min());
    }

    @Test
    void minMany() {
        int expected = 2;
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[]{2, 2})));
        assertEquals(expected, actual.min());
    }

    @Test
    void minEmpty() {
        DataProcessor actual = new DataProcessor(new ArrayList<>(List.of(new Integer[0])));
        assertThrows(NoSuchElementException.class, actual::min);
    }
}
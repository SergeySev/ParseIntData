package org.example;

import java.util.List;

public class DataProcessor {
    List<Integer> data;

    public DataProcessor(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> sorted() {
        return this.data.stream().sorted((a, b) -> b - a).toList();
    }

    public int sumEven() {
        int sum = 0;
        for (int i : this.data) {
            if (i % 2 == 0) sum += i;
        }
        return sum;
    }

    public int avgOdd() {
//среднее значение нечетных
        int sum = 0;
        int count = 0;
        for (int i : this.data) {
            if (i % 2 != 0) {
                sum += i;
                count++;
            }
        }
        return (count >0) ? sum/count : sum;
    }

    public int max() {
        return this.data.stream().max(Integer::compareTo).get();
    }

    public int min() {
        return this.data.stream().min(Integer::compareTo).get();
    }
}

package org.example;

import java.util.ArrayList;

//Напишите программу, которая принимает на вход текстовый файл содержащий числа. Для каждой строки:
//1. отсортировать числа в порядке убывания.
//2. Записать отсортированные числа в файл: исходное_имя_файла_sorted.txt
//3. Подсчитать сумму четных чисел для каждой строки.
//4. Подсчитать среднее значение для нечетных чисел каждой строки.
//5. Найти минимальное и максимальное значение для каждой строки.
//Записать результаты в файл в формате:
//Line: #; SEven: ; AOdd: ; Max: ; Min:
// если ошибка - Line: #; Error

public class Main {
    public static void writeSorted(Writer writer, ArrayList<String> arr) {
        DataProcessor dataProcessor;
        String textSorted;
        int count = 0;
        for (String s : arr) {
            count++;
            try {
                dataProcessor = new DataProcessor(Parser.pars(s));
                textSorted = "Line: " + count + " " + dataProcessor.sorted().toString();
                writer.write(textSorted);
            } catch (InvalidLineException e) {
                writer.write("Line: " + count + "; Error: Line contains letters");
            }
        }
    }

    public static void writeData(Writer writer, ArrayList<String> arr) {
        DataProcessor dataProcessor;
        String textData;
        int count = 0;
        for (String s : arr) {
            count++;
            try {
                dataProcessor = new DataProcessor(Parser.pars(s));
                textData = "Line: " + count +
                        "; SEven: " + dataProcessor.sumEven() +
                        "; AOdd: " + dataProcessor.addOdd() +
                        "; Max: " + dataProcessor.max() +
                        "; Min: " + dataProcessor.min();
                writer.write(textData);
            } catch (InvalidLineException e) {
                writer.write("Line: " + count + "; Error: Line contains letters");
            }
        }
    }

    public static void main(String[] args) {
        String file = "seq2.txt";
        ArrayList<String> arrData = Reader.read(file);
        Writer writerSorted = new Writer(file + "_sorted.txt");
        Writer writerDataProcessor = new Writer(file + "_dataProcessor.txt");

        writeSorted(writerSorted, arrData);
        writeData(writerDataProcessor, arrData);

        writerSorted.close();
        writerDataProcessor.close();
    }
}
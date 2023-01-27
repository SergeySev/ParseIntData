package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final BufferedWriter writer;

    public Writer(String path)  {
        try {
            this.writer = new BufferedWriter(new FileWriter(path)) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void write(String text) {
        try {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
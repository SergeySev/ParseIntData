package org.example;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Integer> pars(String string) throws InvalidLineException {
        List<Integer> result;
        if (checkLine(string)) {
            result = Arrays.stream(string.split(" ")).filter(e-> e.length() > 0).map(Integer::parseInt).toList();
        }
        else throw new InvalidLineException("Invalid line exception");
        return result;
    }

    private static boolean checkLine(String str) {
        boolean isNum = false;
        var array = Arrays.stream(str.split("\\P{LD}+")).filter(e-> e.length() > 0).toList();
        for (String s : array) {
            if (isNumeric(s)) {
                isNum = true;
            } else {
                isNum = false;
                break;
            }
        }
        return isNum;
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

}

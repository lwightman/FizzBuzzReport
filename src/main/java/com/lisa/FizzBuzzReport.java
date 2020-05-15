package com.lisa;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzzReport {
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String SPACE = " ";
    private static final String LUCKY = "lucky";
    private static final String NUMBER = "integer";

    private static Map<String, Integer> report = new HashMap<>();

    static String fizzBuzz(final int input) {
        int number = 1;
        StringBuilder stringInProgress = new StringBuilder();

        while(number <= input) {
            if(containsThree(number)){
                transform(LUCKY, stringInProgress);
            } else if (number % 3 == 0 && number % 5 ==0) {
                transform(FIZZ + BUZZ, stringInProgress);
            } else if (number % 3 == 0) {
                transform(FIZZ, stringInProgress);
            } else if(number % 5 == 0) {
                    transform(BUZZ, stringInProgress);
            } else {
                transform(number, stringInProgress);
            }
            stringInProgress.append(SPACE);
            number++;
        }

        return stringInProgress.toString().trim();
    }

    static void transform(int n, StringBuilder stringInProgress) {
        addToReport(NUMBER);
        stringInProgress.append(n);
    }

    static void transform(String value, StringBuilder stringInProgress) {
        addToReport(value);
        stringInProgress.append(value);
    }

    static void addToReport(String word) {
        int total = 0;
        if(report.containsKey(word)) {
            total = report.get(word);
        }
        report.put(word, ++total);
    }

    static boolean containsThree(int number) {
        return Integer.toString(number).contains("3");
    }

    static void printReport(){
        for(String key : report.keySet()) {
            System.out.println(key +": " +report.get(key));
        }
    }

    public static void main(String[] args) {
        String resultString = fizzBuzz(20);
        System.out.println(resultString);
        printReport();
    }
}

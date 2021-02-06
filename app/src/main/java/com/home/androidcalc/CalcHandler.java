package com.home.androidcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalcHandler {
    private static List<String> tokensOfMainNumbers = new ArrayList<>();
    private static List<Double> numbersOfCalc = new ArrayList<>();
    private static List<Character> mathOperands = new ArrayList<>();
    private static final String TOKENS_OF_MAIN_NUMBERS = "()";
    private static final String TOKENS_OF_NUMBERS = "/*+-";
    private static final String TOKEN_OF_OPERANDS = "0123456789.";

    public static String getTextIn() {
        return MainActivity.getTextIn().getText().toString();
    }

    public void setArrayMainNumbers() {
        tokensOfMainNumbers.clear();
        StringTokenizer stringTokenizer = new StringTokenizer(getTextIn(), TOKENS_OF_MAIN_NUMBERS);
        while (stringTokenizer.hasMoreTokens()) {
            tokensOfMainNumbers.add(stringTokenizer.nextToken());
        }
    }

    public void calcMainNumbers() {
        for (String numbers : tokensOfMainNumbers) {
            if (numbers.contains("+") && numbers.length() > 2) {
                plus(numbers.split("\\+"));
            }
        }
    }

    public double plus(String[] plusNumbers) {
        double answer = 0;
        for (String numbers : plusNumbers) {
            if (numbers.contains("-")) {
                answer += minus(numbers.split("-"));
            } else if (numbers.contains("*")) {
                answer += multiplication(numbers.split("\\*"));
            } else if (numbers.contains("/")) {
                answer += div(numbers.split("/"));
            } else {
                answer = Double.parseDouble(numbers);
            }
        }
        return answer;
    }

    public double minus(String[] minusNumbers) {
        double answer = 0;
        for (String numbers : minusNumbers) {
            if (numbers.contains("*")) {
                answer -= multiplication(numbers.split("\\*"));
            } else if (numbers.contains("/")) {
                answer -= div(numbers.split("/"));
            } else {
                answer -= Double.parseDouble(numbers);
            }
        }
        return answer;
    }

    public double multiplication(String[] multiNumbers) {
        double answer = 1;
        for (String numbers : multiNumbers) {
            if (numbers.contains("/")) {
                answer *= div(numbers.split("/"));
            } else {
                answer *= Double.parseDouble(numbers);
            }
        }
        return answer;
    }

    public double div(String[] divNumbers) {
        double answer = Double.parseDouble(divNumbers[0]);
        for (int i = 1; i < divNumbers.length; i++) {
            answer = answer / Double.parseDouble(divNumbers[i]);
        }
        return answer;
    }

    public void setArrayNumberFromTextIn() {
        numbersOfCalc.clear();
        StringTokenizer stringTokenizer = new StringTokenizer(getTextIn(), TOKENS_OF_NUMBERS);
        while (stringTokenizer.hasMoreTokens()) {
            numbersOfCalc.add(Double.parseDouble(stringTokenizer.nextToken()));
        }
    }

    public void setArrayMarhOperands() {
        mathOperands.clear();
        StringTokenizer stringTokenizer = new StringTokenizer(getTextIn(), TOKEN_OF_OPERANDS);
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.append(stringTokenizer.nextToken());
        }
        for (Character character : stringBuilder.toString().toCharArray()) {
            mathOperands.add(character);
        }

    }


}

package com.home.androidcalc;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CalcHandler implements TokenableCalc {

    private String textIn = "0";

    public void setTextIn(String textIn) {
        this.textIn = textIn;
    }

    public String getTextIn() {
        return textIn;
    }

    public String sendCurrentAnswer() {
//        String textAnswer;
//        textAnswer = String.valueOf(StartPrioryNumbers(getTextIn().split("\\"+TOKEN_OF_PLUS)));
//        return textAnswer;
        return "0";
    }

    public String sendAnswer() {

        return decoderParenthesis(getTextIn());
    }

    public String decoderParenthesis(String codeOfNumbers) {
        String decodeCode;
        if (codeOfNumbers.contains(TOKEN_OF_MAIN_OPEN) || codeOfNumbers.contains(TOKEN_OF_MAIN_CLOSE)) {
            String firstDecode = decoderLastOpenFirstClosedParenthesis(codeOfNumbers);
            String minuAndMinusDecode = minusMultiMinusEqualsPlus(firstDecode.split(TOKEN_OF_MINUS));
            decodeCode = decoderParenthesis(minuAndMinusDecode);
            Log.v("Декодированная строка", firstDecode);
        } else {
            return codeOfNumbers;
        }
            Log.v("Минус на минус", decodeCode);
        return decodeCode;
    }


    public String decoderLastOpenFirstClosedParenthesis(String textIn) {
        StringBuilder stringDecoder = new StringBuilder();
        String[] openParenthesis = textIn.split("\\" + TOKEN_OF_MAIN_OPEN);
        for (int i = 0; i < openParenthesis.length; i++) {
            if (openParenthesis[i].contains(TOKEN_OF_MAIN_CLOSE)) {
                String decoder = decodetFirstClosedParenthesis(openParenthesis[i].split("\\" + TOKEN_OF_MAIN_CLOSE, 2));
                if (i > 0) {
                    stringDecoder.append(appendMultiplicateToCode(openParenthesis[i - 1], false));
                }
                stringDecoder.append(decoder);
                break;
            } else if (i > 0 && openParenthesis[i].length() == 0 && !openParenthesis[i + 1].contains(TOKEN_OF_MAIN_CLOSE)) {
                stringDecoder.append(TOKEN_OF_MAIN_OPEN);
            } else if (i > 0) {
                stringDecoder.append(TOKEN_OF_MAIN_OPEN);
                stringDecoder.append(openParenthesis[i]);
            } else {
                stringDecoder.append(openParenthesis[i]);
            }
        }
        Log.v("Сплит 1", Arrays.toString(openParenthesis));
        return stringDecoder.toString();
    }

    public String appendMultiplicateToCode(String textIn, boolean startTrueOrEndFalse) {
        if (startTrueOrEndFalse) {
            if (textIn.startsWith(TOKEN_OF_PLUS)) {
                return "";
            } else if (textIn.startsWith(TOKEN_OF_MINUS)) {
                return "";
            } else if (textIn.startsWith(TOKEN_OF_DIV)) {
                return "";
            } else if (textIn.startsWith(TOKEN_OF_MULTI)) {
                return "";
            } else if (textIn.length() == 0) {
                return "";
            } else if (textIn.startsWith(TOKEN_OF_MAIN_OPEN) || textIn.startsWith(TOKEN_OF_MAIN_CLOSE)) {
                return "";
            }
        }
        if (!startTrueOrEndFalse) {
            if (textIn.endsWith(TOKEN_OF_PLUS)) {
                return "";
            } else if (textIn.endsWith(TOKEN_OF_MINUS)) {
                return "";
            } else if (textIn.endsWith(TOKEN_OF_DIV)) {
                return "";
            } else if (textIn.endsWith(TOKEN_OF_MULTI)) {
                return "";
            } else if (textIn.length() == 0) {
                return "";
            } else if (textIn.startsWith(TOKEN_OF_MAIN_OPEN) || textIn.startsWith(TOKEN_OF_MAIN_CLOSE)) {
                return "";
            }
        }
        Log.v("Мульти", textIn);
        return TOKEN_OF_MULTI;
    }

    public String decodetFirstClosedParenthesis(String[] splitClosedParenthesisLimitTwo) {
        StringBuilder stringLast = new StringBuilder();
        stringLast.append(String.valueOf(StartPrioryNumbers(splitClosedParenthesisLimitTwo[0].split("\\" + TOKEN_OF_PLUS))));
        if (splitClosedParenthesisLimitTwo.length > 1) {
            stringLast.append(appendMultiplicateToCode(splitClosedParenthesisLimitTwo[1], true));
            stringLast.append(splitClosedParenthesisLimitTwo[1]);
        }
        Log.v("Сплит 2", Arrays.toString(splitClosedParenthesisLimitTwo));
        return stringLast.toString();
    }


    public double StartPrioryNumbers(String[] splitTokenOfPlus) {
        double answer = 0;
        for (String numbers : splitTokenOfPlus) {
            if (numbers.contains(TOKEN_OF_MINUS)) {
                answer += minus(numbers.split(TOKEN_OF_MINUS));
            } else if (numbers.contains(TOKEN_OF_MULTI)) {
                answer += multiplication(numbers.split("\\" + TOKEN_OF_MULTI));
            } else if (numbers.contains(TOKEN_OF_DIV)) {
                answer += div(numbers.split(TOKEN_OF_DIV));
            } else {
                answer += Double.parseDouble(numbers);
            }
        }
        return answer;
    }

    public double minus(String[] splitMinusNumbers) {
        double answer = 0;
        String isNumber;
        for (int i = 0; i < splitMinusNumbers.length; i++) {
            if (splitMinusNumbers[i].contains(TOKEN_OF_MULTI)) {
                if (i == 0) {
                    answer = multiplication(splitMinusNumbers[i].split("\\" + TOKEN_OF_MULTI));
                } else {
                    if (minusAndPlusIsNumber(splitMinusNumbers, i)) {
                        answer -= multiplication((TOKEN_OF_MINUS + splitMinusNumbers[i]).split("\\" + TOKEN_OF_MULTI));
                    } else {
                        answer -= multiplication(splitMinusNumbers[i].split("\\" + TOKEN_OF_MULTI));
                    }
                }
            } else if (splitMinusNumbers[i].contains(TOKEN_OF_DIV)) {
                if (i == 0) {
                    answer = div(splitMinusNumbers[i].split(TOKEN_OF_DIV));
                } else {
                    if (minusAndPlusIsNumber(splitMinusNumbers, i)) {
                        answer -= div((TOKEN_OF_MINUS + splitMinusNumbers[i]).split(TOKEN_OF_DIV));
                    } else {
                        answer -= div(splitMinusNumbers[i].split(TOKEN_OF_DIV));
                    }
                }
            } else {
                if (i == 0 && splitMinusNumbers[i].length() > 0) {
                    answer = Double.parseDouble(splitMinusNumbers[i]);
                } else if (i > 0) {
                    answer -= Double.parseDouble(splitMinusNumbers[i]);
                }
            }
        }
        return answer;
    }

    public boolean minusAndPlusIsNumber(String[] numbers, int numberOfArray) {
        if (numbers.length > 1 && numberOfArray > 0) {
            if (numbers[numberOfArray - 1].endsWith(TOKEN_OF_MULTI)) {
                return true;
            } else if (numbers[numberOfArray - 1].endsWith(TOKEN_OF_DIV)) {
                return true;
            } else if (numbers[numberOfArray - 1].endsWith(TOKEN_OF_MINUS)) {
                return true;
            } else if (numbers[numberOfArray - 1].endsWith(TOKEN_OF_PLUS)) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    public String minusMultiMinusEqualsPlus(String[] splitMinusNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean running;
        int onse = 1;
        int count = 1;
        for (int i = 0; i < splitMinusNumbers.length; i++) {
            if (splitMinusNumbers[i].length() == 0) {
                running = true;
            } else {
                running = false;
            }

            if (running) {
                count++;
            } else {
                if (count != 0 && i != 0) {
                    if (count % 2 == 1) {
                        stringBuilder.append("+");
                        stringBuilder.append(splitMinusNumbers[i]);

                    } else {
                        stringBuilder.append("-");
                        stringBuilder.append(splitMinusNumbers[i]);
                    }
                    count = 0;
                } else if (i == 0) {
                    stringBuilder.append(splitMinusNumbers[i]);
                } else {
                    stringBuilder.append("-");
                    stringBuilder.append(splitMinusNumbers[i]);
                }
            }

        }
        return stringBuilder.toString();
    }

    public double multiplication(String[] multiNumbers) {
        double answer = 1;
        for (String numbers : multiNumbers) {
            if (numbers.contains(TOKEN_OF_DIV)) {
                answer *= div(numbers.split(TOKEN_OF_DIV));
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


}

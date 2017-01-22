package com.glivas.passGen;

import java.util.Random;
import java.util.*;

public class PassGen {
    private static int max(int first, int second) {
        return first > second ? first : second;
    }
    private static final int NUM_NUMBERS = 4;
    private static final int NUM_LOWER = 4;
    private static final int NUM_UPPER = 4;

    private static final int FIRST_NUMBER = 48;
    private static final int TOTAL_NUMBERS = 10;

    private static final int FIRST_LOWER = 97;
    private static final int TOTAL_LOWER = 26;

    private static final int FIRST_UPPER = 65;
    private static final int TOTAL_UPPER = 26;

    private String password;

    static private Random random = new Random();

    private static int[] genSeries(int from, int rangeLength, int seriesLength) {
        int[] series = new int[seriesLength];
        outer: for (int i = 0; i < seriesLength;) {
            int asciiIndex = from + PassGen.random.nextInt(rangeLength);
            for (int j = 0; j < i; j++) {
                if (series[j] == asciiIndex) {
                    continue outer;
                }
            }
            series[i] = asciiIndex;
            i++;
        }
        return series;
    }

    private static SpecialCharRange[] SPECIAL_RANGES = new SpecialCharRange[] {
            new SpecialCharRange(33, 15),
            new SpecialCharRange(58, 7),
            new SpecialCharRange(91, 6),
            new SpecialCharRange(123, 4),
    };

    private static char[] specialChars = new char[15+7+6+4];

    static {
        int index = 0;
        for (int i = 0; i < SPECIAL_RANGES.length; i++) {
            for (int j = 0; j < SPECIAL_RANGES[i].getLength(); j++) {
                specialChars[index++] = (char)(SPECIAL_RANGES[i].getFirst() + j);
            }
        }
    }

    private static char[] genSeriesSpecial(int seriesLength) {
        char[] series = new char[seriesLength];
        outer: for (int i = 0; i < seriesLength;) {
            char asciiChar = specialChars[PassGen.random.nextInt(seriesLength)];
            for (int j = 0; j < i; j++) {
                if (series[j] == asciiChar) {
                    continue outer;
                }
            }
            series[i] = asciiChar;
            i++;
        }
        return series;
    }

    private static String shuffle(char[] passCode) {
        List<Character> passwordList = new ArrayList<Character>();
        for (char c : passCode) {
            passwordList.add(new Character(c));
        }
        Collections.shuffle(passwordList);
        char[] result = new char[passCode.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = passwordList.get(i);
        }

        return new String(result);
    }

    public PassGen(int numNumbers, int numLower, int numUpper, int numSpecial) {
        int[] numbers = PassGen.genSeries(PassGen.FIRST_NUMBER, PassGen.TOTAL_NUMBERS, PassGen.max(numNumbers, PassGen.NUM_NUMBERS));
        int[] lowerCase = PassGen.genSeries(PassGen.FIRST_LOWER, PassGen.TOTAL_LOWER, PassGen.max(numLower, PassGen.NUM_LOWER));;
        int[] upperCase = PassGen.genSeries(PassGen.FIRST_UPPER, PassGen.TOTAL_UPPER, PassGen.max(numUpper, PassGen.NUM_UPPER));;
        char[] special = PassGen.genSeriesSpecial(numSpecial);

        int pasCodeLength = numbers.length
                + lowerCase.length
                + upperCase.length
                + special.length;


        char[] passCode = new char[pasCodeLength];
        int i = 0;

        for(int j = 0; j < numbers.length; j++) {
            passCode[i++] = (char)numbers[j];
        }
        for(int j = 0; j < lowerCase.length; j++) {
            passCode[i++] = (char)lowerCase[j];
        }
        for(int j = 0; j < upperCase.length; j++) {
            passCode[i++] = (char)upperCase[j];
        }
        for(int j = 0; j < special.length; j++) {
            passCode[i++] = special[j];
        }


        this.password = shuffle(passCode);
    }

    public String getPassword() {
        return this.password;
    }

    public static String generateCode (int numOfPasswords) {
        for (int i = 0; i < numOfPasswords-1; i++) {
           return new PassGen(4, 4, 4, 4).getPassword();
        }
        return new PassGen(4, 4, 4, 4).getPassword();
    }
}

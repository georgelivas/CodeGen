package com.glivas.passGen;

import java.util.Random;

public class PassGen {
    private static int max(int first, int second) {
        return first > second ? first : second;
    }
    private static final int NUM_NUMBERS = 4;
    private static final int NUM_LOWER = 4;
    private static final int NUM_UPPER = 4;
    private static final int NUM_SPECIAL = 4;

    private static final int FIRST_NUMBER = 48;
    private static final int TOTAL_NUMBERS = 10;

    private static final int FIRST_LOWER = 26;
    private static final int TOTAL_LOWER = 26;

    private static final int FIRST_UPPER = 65;
    private static final int TOTAL_UPPER = 26;


    private static SpecialCharRange[] SPECIAL_RANGES = new SpecialCharRange[] {
            new SpecialCharRange(33, 15),
            new SpecialCharRange(58, 7),
            new SpecialCharRange(91, 6),
            new SpecialCharRange(123, 4),
    };

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

    public PassGen(int numNumbers, int numLower, int numUpper, int numSpecial) {
        int[] numbers = PassGen.genSeries(PassGen.FIRST_NUMBER, PassGen.TOTAL_NUMBERS, PassGen.max(numNumbers, PassGen.NUM_NUMBERS));
        int[] lowerCase = PassGen.genSeries(PassGen.FIRST_LOWER, PassGen.TOTAL_LOWER, PassGen.max(numLower, PassGen.NUM_LOWER));;
        int[] upperCase = PassGen.genSeries(PassGen.FIRST_UPPER, PassGen.TOTAL_UPPER, PassGen.max(numUpper, PassGen.NUM_UPPER));;


        int pasCodeLength = numbers.length
                + lowerCase.length
                + upperCase.length;


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


        this.password = new String(passCode);
    }

    public String getPassword() {
        return this.password;
    }
}

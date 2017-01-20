package com.glivas.passGen;

public class UserInt {

    public static void loadTUI (int numOfCodes) {
        int numOfCols;
        int divNumOfPasswords;

        if (numOfCodes < 50) {
            numOfCols = 1;
            divNumOfPasswords = numOfCodes;
        } else if (numOfCodes >= 50 && numOfCodes < 100) {
            numOfCols = 2;
            divNumOfPasswords =numOfCodes/2;
        }




        PassGen.generateCode(100);
    }
}

package com.glivas.passGen;

public class UserInt {

    public static void loadTUI (int numOfCodes) {
        PrintLogo.codeGen(1);

        int numOfCols = 1;
        int divNumOfPasswords = 1;

        if (numOfCodes < 50) {
            numOfCols = 1;
            divNumOfPasswords = numOfCodes;
        } else if (numOfCodes >= 50 && numOfCodes < 100) {
            numOfCols = 2;
            divNumOfPasswords = numOfCodes/2;
        }

        if (numOfCols == 2) {
            for (int i = 0; i < divNumOfPasswords; i++) {

            }
        }

        PassGen.generateCode(100);
    }
}

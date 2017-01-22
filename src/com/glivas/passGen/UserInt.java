package com.glivas.passGen;

import java.util.Scanner;

public class UserInt {

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }

        catch (final Exception e) {

        }
    }

    public static void startCodeGen () {
        PrintLogo.codeGen(1);
        System.out.print((char)27 + "[4;m" + "Insert number of passwords:");

        Scanner sc = new Scanner(System.in);
        int numOfCodes = sc.nextInt();

        clearConsole();
        UserInt.loadTUI(numOfCodes);
    }

    public static void loadTUI (int numOfCodes) {

        int numOfCols = 1;
        int divNumOfPasswords = 1;

        if (numOfCodes < 25 ){
            divNumOfPasswords = numOfCodes;
        } else if (numOfCodes >= 25 && numOfCodes <= 50) {
            numOfCols = 2;
            divNumOfPasswords = numOfCodes/2;
        } else if (numOfCodes > 50 && numOfCodes <= 100) {
            numOfCols = 3;
            divNumOfPasswords = numOfCodes/3;
        }


        if (numOfCols == 1) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "--------------------");
                PassGen.generateCode(1);
                System.out.println();

            }
        }


        if (numOfCols == 2) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "-------------------  -------------------");
                PassGen.generateCode(2);
                System.out.println();

            }
        }


        if (numOfCols == 3) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "-------------------  ------------------  -------------------");
                PassGen.generateCode(3);
                System.out.println();

            }
        }
    }
}

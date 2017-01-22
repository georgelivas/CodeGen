package com.glivas.passGen;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class UserInt {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 500; i++) {
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void createDocument (int numOfPasswords) {

        boolean prem = false;

        System.out.print("\n"
                + (char)27
                + "[32;m"
                + numOfPasswords
                + " passwords have been generated."
                + (char)27
                + "[33;m"
                + "\n\nDo you want to export them in a file?(.txt) [y/n]: ");
        Scanner sc = new Scanner(System.in);
        String des = sc.next();

        if(des == "y"){
            prem = true;
        }

        if (prem) {

            Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("generatedPasswords.txt"), "utf-8"));
                writer.write("Its working");
                writer.write("Its working");
                writer.write("\nby George Livas");
            } catch (IOException ex) {

            } finally {
                try {writer.close();} catch (Exception ex) {}
            }
        }
    }

    public static void startCodeGen () {

        clearScreen();

        PrintLogo.codeGen(1);
        System.out.println();
        //System.out.format("%5d", "Insert number of passwords:");
        System.out.print((char)27 + "[33;m" + "Insert number of passwords:");

        Scanner sc = new Scanner(System.in);
        int numOfCodes = sc.nextInt();
        clearScreen();
        PrintLogo.codeGen(1);


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
        } else if (numOfCodes > 50 && numOfCodes <= 75) {
            numOfCols = 3;
            divNumOfPasswords = numOfCodes/3;
        } else if (numOfCodes > 75 && numOfCodes <= 100 || numOfCodes > 100) {
            numOfCols = 4;
            divNumOfPasswords = numOfCodes/4;
        }


        if (numOfCols == 1) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "--------------------");
                PassGen.generateCode(1);
                System.out.println();

            }
            createDocument(numOfCodes);
        }


        if (numOfCols == 2) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "-------------------  -------------------");
                PassGen.generateCode(2);
                System.out.println();

            }
            createDocument(numOfCodes);
        }


        if (numOfCols == 3) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char) 27 + "[31;m" + "-------------------  ------------------  -------------------");
                PassGen.generateCode(3);
                System.out.println();

            }
            createDocument(numOfCodes);
        }


        if (numOfCols == 4) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char) 27 + "[31;m" + "-------------------  ------------------  ------------------  -------------------");
                PassGen.generateCode(4);
                System.out.println();

            }
            createDocument(numOfCodes);
        }
    }
}

package com.glivas.passGen;

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

    public static void startCodeGen (boolean error) {

        if (error == false) {
            clearScreen();
            PrintLogo.codeGen(1);
        }
        System.out.println();
        //System.out.format("%5d", "Insert number of passwords:");
        System.out.print((char)27 + "[33;m" + "Insert number of passwords:");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int numOfCodes = sc.nextInt();
            clearScreen();
            PrintLogo.codeGen(1);
            ProgressBar.delay(5000);

//            loadCodes(numOfCodes);
//            clearScreen();
//            PrintLogo.codeGen(1);

            loadTUI(numOfCodes);
        } else {
            System.out.print((char)27 + "[31;m" + "NOT valid input.\n");
            startCodeGen(true);
        }
    }

    public static void terminateCodeGen (int numOfPasswords) {

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

        if(des.equals("y")){
            clearScreen();
            Holder.createDocument();
            System.out.println((char)27 + "[36;m" + "\nThanks for dropping by.\nSee you later.\n\n");
            System.out.println((char)27 + "[32;m" );
        } else if (des.equals("n")) {
            System.out.println((char)27 + "[36;m" + "\nThanks for dropping by.\nSee you later.\n\n");
            System.out.println((char)27 + "[32;m" );
        } else {
            System.err.println((char)27 + "[31;m" + "\n\n\n" + des + " is NOT a valid answer.");
            terminateCodeGen(numOfPasswords);
        }
    }

    public static void loadCodes (int numOfCodes) {
        int delay = numOfCodes * 20;
        System.out.println("Generating codes...");

        try {
            Thread.sleep(delay);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public static void loadTUI (int numOfCodes) {

        int numOfCols = 1;
        int divNumOfPasswords = 1;

        Holder.genCodes(numOfCodes);

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
                System.out.println((char)27 + "[31;m" + "|------------------|");
                Holder.printCodes(1);
                System.out.println();
            }
            terminateCodeGen(numOfCodes);
        }


        if (numOfCols == 2) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char)27 + "[31;m" + "|------------------||------------------|");
                Holder.printCodes(2);
                System.out.println();
            }
            terminateCodeGen(numOfCodes);
        }


        if (numOfCols == 3) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char) 27 + "[31;m" + "|------------------||------------------||------------------|");
                Holder.printCodes(3);
                System.out.println();
            }
            terminateCodeGen(numOfCodes);
        }


        if (numOfCols == 4) {
            for (int i = 0; i < divNumOfPasswords; i++) {
                System.out.println((char) 27 + "[31;m" + "|------------------||------------------||------------------||------------------|");
                Holder.printCodes(4);
                System.out.println();
            }
            terminateCodeGen(numOfCodes);
        }
    }
}

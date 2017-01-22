package com.glivas.passGen;

import java.io.*;

public class Holder {

     static String[] keyHolder;

    public static void genCodes (int numOfCodes) {
        keyHolder = new String[numOfCodes];
        for (int i = 0; i < keyHolder.length; i++) {
            keyHolder[i] = PassGen.generateCode(1);
        }
    }

    public static void printCodes (){
        for (int i = 0; i < keyHolder.length; i++) {
            System.out.print((char)27
                + "[31;m"
                + "| "
                + (char)27
                + "[36;m"
                + keyHolder[i]
                + (char)27
                + "[31;m"
                + " |"
            );

        }
    }

    public static void createDocument (int numOfPasswords) {

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


//              System.out.print((char)27
//                    + "[31;m"
//                    + "| "
//                    + (char)27
//                    + "[36;m"
//                    + new PassGen(4, 4, 4, 4).getPassword()
//                    + (char)27
//                    + "[31;m"
//                    + " |");
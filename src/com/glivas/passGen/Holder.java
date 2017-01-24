package com.glivas.passGen;

import java.io.*;

public class Holder {

    static String[] keyHolder;
    static int index = 0;

    public static void genCodes (int numOfCodes) {
        keyHolder = new String[numOfCodes];
        for (int i = 0; i < keyHolder.length; i++) {
            keyHolder[i] = PassGen.generateCode(1);
        }
    }

    public static void printCodes (int codesPerLine){

        for (int i = 0; i < codesPerLine; i++) {
            System.out.print((char)27
                + "[31;m"
                + "| "
                + (char)27
                + "[36;m"
                + keyHolder[index]
                + (char)27
                + "[31;m"
                + " |"
            );
            index++;
        }
    }

    public static void createDocument () {
        BufferedWriter writer = null;
        try {
            String fileName = "Generated Codes";
            File codeFile = new File(fileName);

            System.out.print((char)27 + "[32;m" + "The file is located at:  ");
            System.out.println((char)27 + "[31;m" + codeFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(codeFile));
            writer.write(
                    "  _____        __    _____       \n" +
                    " / ___/__  ___/ /__ / ___/__ ___ \n" +
                    "/ /__/ _ \\/ _  / -_) (_ / -_) _ \\\n" +
                    "\\___/\\___/\\_,_/\\__/\\___/\\__/_//_/\n" +
                    "                                 \n");

            for (int i = 0; i < keyHolder.length; i++) {
                writer.write(keyHolder[i]);
                writer.write("\n");
            }
            writer.write("\n\nCreated by George Livas");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                writer.close();
            } catch (Exception e) {
            }
        }
    }
}

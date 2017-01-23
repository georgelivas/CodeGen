package com.glivas.passGen;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public static void createDocument () {
        System.out.println(keyHolder.length);
        BufferedWriter writer = null;
        try {
            String fileName = "Generated Codes";
            File logFile = new File(fileName);

            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
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

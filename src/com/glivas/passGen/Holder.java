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

        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));

            for (int i = 0; i < keyHolder.length; i++) {
                writer.write(keyHolder[i]);
                writer.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }



//        Writer writer = null;
//
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("generatedPasswords.txt"), "utf-8"));
//            writer.write("Its working");
//            writer.write("Its working");
//            writer.write("\nby George Livas");
//        } catch (IOException ex) {
//
//        } finally {
//            try {writer.close();} catch (Exception ex) {}
//        }
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
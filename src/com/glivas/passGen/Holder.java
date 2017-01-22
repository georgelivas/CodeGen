package com.glivas.passGen;

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
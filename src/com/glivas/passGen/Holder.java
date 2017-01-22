package com.glivas.passGen;

public class Holder {

     static int numOfPasswords;
     static String[] keyHolder = new String[numOfPasswords];

    public Holder(int numOfPasswords) {
        this.numOfPasswords = numOfPasswords;
    }
    public static String passwordHolder () {
        for (int i = 0; i < numOfPasswords; i++) {
            keyHolder[i] = PassGen.generateCode(1);
        }
    }
}

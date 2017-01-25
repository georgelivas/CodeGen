package com.glivas.passGen;

import java.util.Scanner;

public class StartUp {
    public static void CodeGen () {
        UserInt.clearScreen();
        PrintLogo.codeGen(1);

        System.out.println((char)27 + "[32;m" + "CodeGen is a code generator which can create codes of 16 characters\n" +
                "long and the user haves the ability to store them in a text file (.txt). Each password \n" +
                "contains 4 capital letters (A,B,C), 4 lowercase letters (a,b,c), 4 numbers (1,2,3)\n" +
                "and 4 special characters (!,@,£) in random order.\n" +
                "So the outcome is similar to this: " + (char)27 + "[31;m" + " \"$0GyLs!#fjJ\"7P49\"\n"+ (char)27 + "[32;m"  +
                "The outcome is unpredictable and the possibility of a code been generated twice is 0,3333333%.\n\n" + (char)27 + "[36;m"  +
                "1) To start press [enter].\n" +
                "2) To exit press [^c]"
        );

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            UserInt.startCodeGen(false);
        }
    }
}

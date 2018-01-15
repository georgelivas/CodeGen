package com.glivas.passGen;

import java.util.Scanner;

public class StartUp {
    public static void CodeGen () {
        PrintLogo.codeGen(1);

        System.out.println((char)27 + "[36;m"  +
                "1) To start press [enter].\n" +
                "2) To exit press [^c]"
        );

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            UserInt.startCodeGen(false);
        }
    }
}

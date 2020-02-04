package com.nomura.codingtest;

import java.io.File;
import java.io.IOException;

public class Launcher
{
    public static void main(String[] args) {
        if(args.length != 1 || args[0].trim().contains("help")) {
            printHelp();
            return;
        }

        MaxSum ms = new MaxSum();
        final String fileName = args[0].trim();
        PascalsTriangle pt;
        try {
            pt = PascalsTriangleImpl.from(new File(fileName));
        } catch (RuntimeException|IOException e) {
            final String msg = String.format(" Unable to read from the specified file %s\t Exception : %s", fileName, e.getMessage());
            System.out.println(msg);
            return;
        }
        long result = ms.maxSum(pt);
        System.out.println(" Max sum of verticalTrace is " + result);
    }

    private static void printHelp() {
        System.out.println("Usage: java -jar <jarName> <triangleFileName>\n ");
    }
}

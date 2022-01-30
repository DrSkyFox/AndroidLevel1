package ru.gb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static Boolean useScanner =false;
    private static Tote tote = null;

    public static void main(String[] args) {

        Iterator<String> stringIterator = Arrays.stream(args).iterator();
        while (stringIterator.hasNext()) {
            if(stringIterator.next().equals("-scanner")) {
                useScanner = true;
            }
        }

        System.out.println("useScanner: " + useScanner);
        if(!useScanner) {
            tote =new Tote();
        } else {
            tote = new Tote(new Scanner(System.in));
        }

        System.out.println("Open thread");
        Thread toteRun = new Thread(tote,"ToteGame");
        System.out.println("Start Thread " + toteRun.getName());
        toteRun.run();

        try {
            toteRun.join();
            System.out.println("Thread joined");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

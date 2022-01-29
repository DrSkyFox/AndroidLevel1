package ru.gb;

public class Main {
    public static void main(String[] args) {
        Tote tote =new Tote();
        Thread toteRun = new Thread(tote);

        toteRun.run();

        try {
            toteRun.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

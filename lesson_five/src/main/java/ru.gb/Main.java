package ru.gb;

public class Main {

    public static void main(String[] args) {

        Worker[] workers = new Worker[] {
                new Worker.Builder().firstName("Vasa").secondName("Dlinniy").age(30).email("vasa@email.ru").phone(123456789).salary(1000).build(),
                new Worker.Builder().firstName("Vana").secondName("Shirokiy").age(20).email("vana@email.ru").phone(45664651).salary(16500).build(),
                new Worker.Builder().firstName("Alex").secondName("Izeberg").age(44).email("alex@email.ru").phone(154894161).salary(1300).build(),
                new Worker.Builder().firstName("Sara").secondName("Konor").age(23).email("sara@email.ru").phone(129618163).salary(2000).build(),
                new Worker.Builder().firstName("Qustav").secondName("Shect").age(43).email("qustav@email.ru").phone(12651564).salary(1560).build()
        };

        for (Worker worker: workers
             ) {
            if(worker.getAge() > 40) {
                System.out.println(worker);
            }
        }
    }
}

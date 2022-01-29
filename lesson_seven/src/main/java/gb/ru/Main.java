package gb.ru;

import gb.ru.intefraces.Consumable;
import gb.ru.intefraces.Storagable;
import gb.ru.model.Cat;
import gb.ru.model.Plate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Consumable> consumables;
        System.out.println("Сколько котов ?");
        if(scanner.hasNextInt()) {
             consumables = consumables(scanner.nextInt());
        } else {
            consumables = consumables(5);
        }

        Storagable storage = getStorage();

        System.out.println("Тарелка: " + storage);
        System.out.println(consumables);

        timeToFeed(consumables, storage);

        printArray(consumables);



    }

    private static void printArray(List<Consumable> consumables) {
        for (Consumable consumable: consumables
             ) {
            System.out.println(consumable);
        }
    }

    private static void timeToFeed(List<Consumable> consumables, Storagable storagable) {
        for (Consumable consumable: consumables
             ) {
            consumable.consume(storagable);
        }
    }


    private static List<Consumable> consumables(int count) {
        Random random = new Random();
        List<Consumable> consumables = new ArrayList<>();
        for (int i = 0; i <count; i++) {
            consumables.add(new Cat(random.nextInt(100)));
        }
        return consumables;
    }

    private static Storagable getStorage() {
        return new Plate(new Random().nextInt(1000));
    }

}

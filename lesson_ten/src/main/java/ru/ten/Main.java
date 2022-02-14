package ru.ten;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> strings = List.of("sjdhs", "skjal", "wieji", "sjdhs", "12sdee121", "sdsd2ers", "215ds5fd", "45sd456vcd", "skjal", "qwerty", "sjdhs");
        calcUnique(strings);

        var phoneBook = new PhoneBook();

        phoneBook.addPhone("Vasay", 5155645);
        phoneBook.addPhone("Ann", 15615656);
        phoneBook.addPhone("Ann", 454654456);
        phoneBook.addPhone("jora", 152456564);

        System.out.println("Ищем Ann");
        System.out.println(phoneBook.getNumber("Ann"));

        System.out.println("Ищем jora");
        System.out.println(phoneBook.getNumber("jora"));



    }


    private static void calcUnique(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: list
             ) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 0);
            }

        }
        System.out.println("Уникальных - " + map.size());
        System.out.println("Повторяющихся - " + (list.size() - map.size()));
        System.out.println("Элементы");
        System.out.println(map);
    }


}

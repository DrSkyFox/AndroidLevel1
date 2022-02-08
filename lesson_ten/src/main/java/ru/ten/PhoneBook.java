package ru.ten;

import java.util.*;

public class PhoneBook {

    private Map<String, List<Integer>> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    public void addPhone(String name, Integer phone) {
        name = name.toUpperCase();
        if(phones.containsKey(name)) {
            phones.get(name).add(phone);
            return;
        }
        List<Integer> numbers = new ArrayList<>();
        numbers.add(phone);
        phones.put(name,numbers);
    }

    public List<Integer> getNumber(String name) {
        name = name.toUpperCase();
        if(phones.containsKey(name)) {
            return phones.get(name);
        } else return null;
    }


}

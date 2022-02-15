package fructics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket<T extends Fruit> implements Comparator<Basket> {

    private List<T> fruits;
    private Double totalWeight;

    public Basket() {
        fruits = new ArrayList<>();
        totalWeight = 0.0;
    }

    public void addFruits(T t) {
        fruits.add(t);
        totalWeight += t.getWeight();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setFruits(List<T> fruits) {
        this.fruits = fruits;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void transferFrom(Basket<T> basket) {
        fruits.addAll(basket.getFruits());
        totalWeight += basket.getTotalWeight();

        basket.setFruits(null);
        basket.setTotalWeight(0.0);
    }


    @Override
    public int compare(Basket o1, Basket o2) {
        System.out.println("o1 - " + o1.getTotalWeight());
        System.out.println("o2 - " + o2.getTotalWeight());

        if(o1.getTotalWeight().equals(o2.getTotalWeight())) {
            return 1;
        } else return 0;
    }
}

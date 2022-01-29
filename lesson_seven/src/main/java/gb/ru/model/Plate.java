package gb.ru.model;


import gb.ru.intefraces.Storagable;

import java.util.Objects;

public class Plate implements Storagable {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }


    @Override
    public void addSomeResources(Integer count) {
        System.out.println("Resources added");
        food += count;
    }

    @Override
    public Integer getSomeResources(Integer count) {
        System.out.println("Запрос на ресурсы: " + count);
        if(getFood() < count) {
            System.out.println("not enough resources");
            return null;
        } else  {
            food -= count;
            System.out.println("Ресурсы получены. Осталось: " + getFood());
            return  count;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return food == plate.food;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food);
    }


    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}

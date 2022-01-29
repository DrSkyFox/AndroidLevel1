package gb.ru.model;

import gb.ru.intefraces.Consumable;
import gb.ru.intefraces.Storagable;

public class Cat implements Consumable {

    private static int counter;
    private static final String DEFAULT_NAME = "Cat";
    private String name;

    private Integer consumption;
    private Boolean wellFed;


    public Cat(Integer consumption) {
        this.name = DEFAULT_NAME + " " + (++counter);
        this.consumption = consumption;
        this.wellFed = false;
    }


    @Override
    public void consume(Storagable storagable) {
        var getResource= storagable.getSomeResources(consumption);
        if(getResource != null) {
            wellFed = true;
            System.out.println(name + " eated on " + getResource);
        } else System.out.println(name + " is hungry");

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                ", wellFed=" + wellFed +
                '}';
    }
}

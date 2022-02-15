import fructics.Apple;
import fructics.Basket;
import fructics.Orange;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        swappers();

        Basket<Orange> orangeBasket = new Basket<>();
        Basket<Apple> appleBasket = new Basket<>();

        orangeBasket.addFruits(new Orange());
        System.out.println(orangeBasket.getTotalWeight());

        System.out.println("add orange");
        orangeBasket.addFruits(new Orange());
        System.out.println(orangeBasket.getTotalWeight());

        System.out.println("add apple");
        appleBasket.addFruits(new Apple());
        appleBasket.addFruits(new Apple());
        System.out.println(appleBasket.getTotalWeight());

        System.out.println("Compare");
        System.out.println(appleBasket.compare(appleBasket,orangeBasket));

        System.out.println("Add some apple and compare");
        appleBasket.addFruits(new Apple());
        System.out.println(appleBasket.getTotalWeight());
        System.out.println(appleBasket.compare(appleBasket,orangeBasket));


        Basket<Apple> appleBasket2 = new Basket<>();
        appleBasket2.addFruits(new Apple());
        System.out.println("appleBasket2.getTotalWeight() " +  appleBasket2.getTotalWeight());
        System.out.println("Transfer apple from appleBasket1");
        appleBasket2.transferFrom(appleBasket);
        System.out.println("appleBasket2.getTotalWeight() " + appleBasket2.getTotalWeight());
        System.out.println("appleBasket1.getTotalWeight() " + appleBasket.getTotalWeight());
    }

    private static void swappers() {
        String[] strs = new String[] {
                "case", "test", "swap", "body"
        };

        Integer[] ints = new Integer[] {
                1,2,3,4,5,6
        };

        System.out.println(Arrays.asList(strs));
        System.out.println(Arrays.asList(ints));


        Swapper.swapElement(strs, 2,3);
        System.out.println(Arrays.asList(strs));

        Swapper.swapElement(ints, 2,5);
        System.out.println(Arrays.asList(ints));

        System.out.println("List");
        var list = Swapper.swapToList(ints);
        System.out.println(list);
    }

}

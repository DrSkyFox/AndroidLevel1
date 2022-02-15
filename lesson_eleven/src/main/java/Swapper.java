import java.util.ArrayList;
import java.util.List;

public class Swapper {

    public static <T> void swapElement(T[] t, int i, int j) {

        Object temp = t[i];
        t[i] = t[j];
        t[j] = (T) temp;
    }


    public static <T> List<T> swapToList(T[] t) {
        List<T> temp = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            temp.add(t[i]);
        }
        return temp;
    }



}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListIntroduction2 {
    public static void main(String[] args) {
        List<String> ListA = new ArrayList<>();
        ListA.add("Apple");
        ListA.add("Avocado");
        ListA.add("Blueberries");
        ListA.add("Durian");
        ListA.add("Lychee");

        List<String> ListB = new ArrayList<>();
        ListB.addAll(ListA);

        System.out.println(ListA.contains("Durian"));

        ListB.remove("Durian");

        ListA.add(3, "Kiwifruit");

        if (ListA.size() > ListB.size()) {
            System.out.println("List A size is bigger than List B size.");
        } else if (ListA.size() == ListB.size()) {
            System.out.println("List A size equals List B size.");
        } else {
            System.out.println("List B size is bigger than List A size.");
        }

        System.out.println(ListA.indexOf("Avocado"));

        System.out.println(ListB.indexOf("Durian"));

        Collections.addAll(ListB, "Passion Fruit", "Pummelo");

        System.out.println(ListA.get(2));
    }
}

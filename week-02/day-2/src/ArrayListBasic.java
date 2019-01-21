import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(90);
        grades.add(85);
        grades.add(70);

        for (int i = 0; i   < grades.size(); i++) {
            System.out.printf("Grade #%d = %d\n", i, grades.get(i));
        }

        System.out.println("\n");

        grades.remove(1);

        for (int i = 0; i < grades.size(); i++) {
            System.out.println(grades.get(i));
        }

        System.out.println("\n");

        ArrayList<String> names = new ArrayList<String>();

        names.add("John Smith");
        names.add("Mohamed Ali");
        names.add("Oliver Miller");

        names.add(2, "Jack Ryan");

        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
        }

        System.out.println("\n");

        names.set(0, "John Adams");
        System.out.println(names.get(0));


        System.out.println("\n");

        names.remove(3);
        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
        }

        names.add("Jack Black");
        names.add("Ryan Gosling");

        System.out.println("\n");

       // names.removeRange(0, 1);

        System.out.println(names);

        System.out.println("\n");

        for(String temp : names) {
            System.out.println(temp);
        }

        System.out.println("\n");


        Iterator indivItems = names.iterator();

        while(indivItems.hasNext()) {
            System.out.println(indivItems.next());
        }

        System.out.println("\n");

        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();

        nameCopy.addAll(names);

        String paulYoung = "Paul Young";

        names.add(paulYoung);

        if(names.contains(paulYoung)) {
            System.out.println("Paul is here.");
        }

        System.out.println("\n");

        if(names.containsAll(nameCopy)) {
            System.out.println("Everything is here.");
        }

        System.out.println("\n");

        //Copied everything from names to nameCopy
        //Added a value to names

        if(nameCopy.containsAll(names)) {
            System.out.println("Everything is here.");
        }

        names.clear();

        if (names.isEmpty()) {
            System.out.println("ArrayList names is empty");
        }

        Object[] moreNames = new Object[5];
        moreNames = nameCopy.toArray();

        System.out.println(Arrays.toString(moreNames));

    }
}

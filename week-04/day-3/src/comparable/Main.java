package comparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));

        for (Domino domino : dominoes) {
            System.out.print(domino);
        }
        System.out.println();

        Collections.sort(dominoes);

        for (Domino domino : dominoes) {
            System.out.print(domino);
        }
        System.out.println();

        printLine();

        List<Thing> todos = new ArrayList<>();
        todos.add(new Thing("shopping", true));
        todos.add(new Thing("showering", false));
        todos.add(new Thing("shopping", false));
        todos.add(new Thing("walking the dog", true));
        todos.add(new Thing("arriving", true));
        todos.add(new Thing("answering", false));

        Collections.sort(todos);

        for (Thing todo : todos) {
            System.out.println(todo);
        }

        printLine();

        for (Domino d : dominoes) {
            d.printAllFields();
        }

        printLine();

        for (Thing t : todos) {
            t.printAllFields();
        }
    }

    public static void printLine() {
        System.out.println();
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }

}

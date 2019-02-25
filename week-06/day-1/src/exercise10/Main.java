package exercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Create a Fox class with 3 properties (name, color, age) Fill a list with at least 5 foxes and:
        //
        //Write a Stream Expression to find the foxes with green color!
        //Write a Stream Expression to find the foxes with green color, and age less then 5 years!
        //Write a Stream Expression to find the frequency of foxes by color!

        List<Fox> foxes = new ArrayList<>();
        foxes.add(new Fox("Vulpes lagopus", "white", 5));
        foxes.add(new Fox("Vulpes zerda", "cream", 6));
        foxes.add(new Fox("Vulpes vulpes", "red", 3));
        foxes.add(new Fox("Vulpes teaser", "green", 8));
        foxes.add(new Fox("Vulpes coders", "green", 2));
        foxes.add(new Fox("Vulpes astral", "green", 4));

        foxes.stream()
                .filter(f -> f.color.equals("green"))
                .forEach(f -> System.out.print(f.name + ", "));

        System.out.println();

        List<String> greenFoxes = foxes.stream()
                .filter(f -> f.color.equals("green"))
                .collect(Collectors.mapping(f -> f.getName(), Collectors.toList()));

        System.out.println(greenFoxes);

        List<String> greenFoxes2 = foxes.stream()
                .filter(f -> f.color.equals("green"))
                .map(f -> f.getName())
                .collect(Collectors.toList());

        System.out.println(greenFoxes2);

        foxes.stream()
                .filter(f -> f.color.equals("green") && f.age < 5)
                .forEach(f -> System.out.print(f.name + ", "));

        System.out.println();

        List<String> youngGreenFoxes = foxes.stream()
                .filter(f -> f.color.equals("green") && f.age < 5)
                .collect(Collectors.mapping(f -> f.getName() + " = " + f.getAge(), Collectors.toList()));

        System.out.println(youngGreenFoxes);

        List<String> youngGreenFoxes2 = foxes.stream()
                .filter(f -> f.color.equals("green") && f.age < 5)
                .map(f -> f.getName())
                .collect(Collectors.toList());

        System.out.println(youngGreenFoxes2);

        Map<String, Long> groupedFoxes = foxes.stream()
                .collect(Collectors.groupingBy(f -> f.getColor(), Collectors.counting()));
        System.out.println(groupedFoxes);

        Map<String, List<Fox>> groupedFoxes2 = foxes.stream()
                .collect(Collectors.groupingBy(f -> f.getColor(), Collectors.toList()));
        System.out.println(groupedFoxes2);

        Map<String, List<String>> groupedFoxes3 = foxes.stream()
                .collect(Collectors.groupingBy(f -> f.getColor(), Collectors.mapping(f -> f.getName(), Collectors.toList())));
        System.out.println(groupedFoxes3);


    }
}

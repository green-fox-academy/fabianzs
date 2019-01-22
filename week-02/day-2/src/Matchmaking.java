import java.util.*;

public class Matchmaking{
    public static void main(String... args){
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // If someone has no pair, he/she should be the element of the list too
        // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

        System.out.println(makingMatches(girls, boys));
    }

    public static List<String> makingMatches (List<String> inputList1, List<String> inputList2) {

        ArrayList<String> matchList = new ArrayList<>();

        if (inputList1.size() < inputList2.size()) {
            for (int i = 0; i < inputList1.size(); i++) {
                matchList.add(inputList1.get(i));
                matchList.add(inputList2.get(i));
            }

            for (int i = inputList1.size(); i < inputList2.size() ; i++) {
                matchList.add(inputList2.get(i));
            }

            return matchList;
        } else {
            for (int i = 0; i < inputList2.size(); i++) {
                matchList.add(inputList1.get(i));
                matchList.add(inputList2.get(i));
            }

            for (int i = inputList2.size(); i < inputList1.size() ; i++) {
                matchList.add(inputList1.get(i));
            }

            return matchList;
        }


    }
}
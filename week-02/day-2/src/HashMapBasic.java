import java.util.HashMap;

public class HashMapBasic {
    public static void main(String[] args) {

        //Create a HashMap

        HashMap<String, String> hm = new HashMap<String, String>();

        //Put data

        hm.put("Katie", "Android, Wordpress");
        hm.put("Magda", "Facebook");
        hm.put("Vanessa", "Tools" );
        hm.put("Ania", "Java");
        hm.put("Ania", "JEE");  //old value is overwritten

        //HashMap iteration
        for (String temp : hm.keySet()) {
            System.out.println(temp + " : " + hm.get(temp));
        }

        System.out.println("\n");

        if(hm.containsKey("Katie")) {
            System.out.println("HashMap contains key Katie");
        }

        System.out.println("\n");

        if(hm.containsValue("Cooking")) {
            System.out.println("HashMap contains value Cookie");
        } else {
            System.out.println("HashMap doesn't contain value Cookie");
        }
    }
}

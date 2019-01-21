import java.util.Arrays;

public class AppendA {
    public static void main(String[] args) {
        // - Create an array variable named `animals`
        //   with the following content: `["koal", "pand", "zebr"]`
        // - Add all elements an `"a"` at the end

        String[] animals = {"koal", "pand", "zebr"};

        for (int i = 0; i < animals.length; i++) {
            animals[i] = animals[i] + "a";
        }

        System.out.println(Arrays.toString(animals));
    }
}

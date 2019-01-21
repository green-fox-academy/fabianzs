import java.util.Arrays;

public class Colors {
    public static void main(String[] args) {
        // - Create a two dimensional array
        //   which can contain the different shades of specified colors
        // - In `colors[0]` store the shades of green:
        //   `"lime", "forest green", "olive", "pale green", "spring green"`
        // - In `colors[1]` store the shades of red:
        //   `"orange red", "red", "tomato"`
        // - In `colors[2]` store the shades of pink:
        //   `"orchid", "violet", "pink", "hot pink"`

        String[][] colors = {{"lime", "forest green", "olive", "pale green", "spring green"},
                             {"orange red", "red", "tomato"},
                             {"orchid", "violet", "pink", "hot pink"},};

        for (int i = 0; i < colors.length ; i++) {
            System.out.println(Arrays.toString(colors[i]));
        }

        System.out.println("\n");

        String[][] colors1 = new  String[3][5];
        colors1 [0] = new String[]{"lime", "forest green", "olive", "pale green", "spring green"};
        colors1 [1] = new String[] {"orange red", "red", "tomato"};
        colors1 [2] = new String[] {"orchid", "violet", "pink", "hot pink"};

        for (int i = 0; i < colors1.length ; i++) {
            System.out.println(Arrays.toString(colors[i]));
        }


    }
}

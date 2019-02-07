import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {
    public int add(int a, int b) {
        return a + b;
    }

    public int maxOfThree(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        else
            return c;
    }

    public double median(List<Integer> pool) {
        Collections.sort(pool);
        if (pool.isEmpty()) {
            throw new NullPointerException();
        }
        if (pool.size() % 2 == 1) {
            return (double) pool.get((pool.size() - 1) / 2);
        } else {
            return (double)((pool.get((pool.size() - 1) / 2) + pool.get((pool.size() - 1) / 2 + 1)) / 2);
        }
    }

    public boolean isVowel(char c) {
        return Arrays.asList('a', 'á', 'u', 'ú', 'o', 'ó', 'e', 'é', 'i', 'í', 'ö', 'ő', 'ü', 'ű').contains(c);
    }

    public String translate(String hungarian) {
        String teve = hungarian;
        int length = teve.length();
        for (int i = 0; i < length; i++) {
            char c = teve.charAt(i);
            if (isVowel(c)) {
                teve = String.join(c + "v" + c, teve.substring(0, i), teve.substring(i + 1));
                i+=2;
                length+=2;
            }
        }
        return teve;
    }
}
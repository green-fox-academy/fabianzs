package fabian.zsofia.frontend.models;

import java.util.Arrays;

public class ArrayHandler {

    private Object result;

    public ArrayHandler(String what, int[] numbers) {
        if (what.equals("sum")) {
            this.result = Arrays.stream(numbers).sum();
        } else if (what.equals("multiply")) {
            this.result = Arrays.stream(numbers).reduce(1, (n1, n2) -> n1 * n2);
        } else if (what.equals("double")) {
            this.result = Arrays.stream(numbers)
                    .map(n -> 2 * n)
                    .toArray();
        }
    }

    public Object getResult() {
        return result;
    }
}

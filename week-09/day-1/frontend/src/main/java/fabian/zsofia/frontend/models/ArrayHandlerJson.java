package fabian.zsofia.frontend.models;

import java.util.Arrays;

public class ArrayHandlerJson {

    private String what;
    private int[] numbers;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "ArrayHandlerJson{" +
                "what='" + what + '\'' +
                ", numbers=" + Arrays.toString(numbers) +
                '}';
    }
}

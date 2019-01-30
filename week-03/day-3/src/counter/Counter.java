package counter;

public class Counter {
    int defaultValue;
    int counterValue;

    public Counter() {
        this.defaultValue = 0;
        this.counterValue = 0;
    }

    public Counter(int defaultValue) {
        this.defaultValue = defaultValue;
        this.counterValue = defaultValue;
    }

    public void add (int number) {
        this.counterValue += number;
    }

    public void add() {
        this.counterValue += 1;
    }

    public int get() {
        return this.counterValue;
    }

    public void reset() {
        this.counterValue = this.defaultValue;
    }
}

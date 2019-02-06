package charsequence;

public class Shifter implements CharSequence {
    String string;
    int shift;

    public Shifter(String string, int shift) {
        this.string = string;
        this.shift = shift;
    }

    @Override
    public int length() {
        int length = 0;
        for (char character : this.string.toCharArray()){
            length++;
        }
        return length;
    }

    @Override
    public char charAt(int index) {
        char[] charArray = this.string.toCharArray();
        if (index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index + this.shift < this.length()) {
            return charArray[index + this.shift];
        }
        return charArray[index + this.shift - this.length()];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String temp = "";
        for (int i = 0; i < end - start; i++) {
            temp += this.charAt(start + i);
        }
        return temp;
    }
}

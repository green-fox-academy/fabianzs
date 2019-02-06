package charsequence;

public class Gnirts implements CharSequence {
    String string;

    public Gnirts(String string) {
        this.string = string;
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
        return charArray[this.string.length() - 1 - index];
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

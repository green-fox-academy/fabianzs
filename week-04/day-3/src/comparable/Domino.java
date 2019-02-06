package comparable;

import printable.Printable;

public class Domino implements Comparable<Domino>, Printable {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

 /*   @Override
    public int compareTo(Domino other) {
        int result = Integer.compare(this.left, other.left);
        if (result == 0) {
            result = Integer.compare(this.right, other.right);
        }
        return result;
    }*/

    @Override
    public int compareTo(Domino other) {
        if (this.left > other.left) {
            return 1;
        }
        if (this.left == other.left) {
            if (this.right > other.right) {
                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public void printAllFields() {
        System.out.println(this.left + " " + this.right);
    }
}
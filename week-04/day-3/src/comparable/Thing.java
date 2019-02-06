package comparable;

import printable.Printable;

public class Thing implements Comparable<Thing>, Printable {
    public String description;
    public boolean completed;

    public Thing(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }


    @Override
    public int compareTo(Thing other) {
        if (this.completed == other.completed) {
            return this.description.compareTo(other.description);
        }
        if (this.completed) {
            return -1;
        }
        return 1;
    }

    @Override
    public void printAllFields() {
        System.out.println(this.description + " " + this.completed);
    }
}
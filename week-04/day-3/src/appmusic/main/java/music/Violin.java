package appmusic.main.java.music;

public class Violin extends StringedInstrument {

    public Violin() {
        this.name = "Violin";
        this.numberOfStrings = 4;
    }

    public Violin(int numberOfStrings) {
        this.name = "Violin";
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String sound() {
        return "Screech";
    }
}

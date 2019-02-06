package appmusic.main.java.music;

public class BassGuitar extends StringedInstrument {

    public BassGuitar() {
        this.name = "Bass Guitar";
        this.numberOfStrings = 4;
    }

    public BassGuitar(int numberOfStrings) {
        this.name = "Bass Guitar";
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String sound() {
        return "Duum-duum-duum";
    }
}

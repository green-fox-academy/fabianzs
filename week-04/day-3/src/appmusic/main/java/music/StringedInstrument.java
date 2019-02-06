package appmusic.main.java.music;

public abstract class StringedInstrument extends Instrument {

    int numberOfStrings;

    @Override
    public void play() {
        System.out.println(this.name + ", a " + this.numberOfStrings + "-stringed instrument that goes " + this.sound());
    }

    public abstract String sound();
}

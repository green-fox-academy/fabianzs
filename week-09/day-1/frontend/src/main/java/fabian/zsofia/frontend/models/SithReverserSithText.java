package fabian.zsofia.frontend.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SithReverserSithText {

    private String sith_text;

    public SithReverserSithText(SithReverserText sithReverserText) {
        List<String> randomString = new ArrayList<>(Arrays.asList("Arrgh.", "Uhmm.", "Err..err.err."));
        String[] allstring = sithReverserText.getText().split("\\.");
        String sithText = "";
        for (String string : allstring) {
            String[] wordsInOneString = string.trim().split(" ");
            String reversedString = "";
            for (int i = 0; i < wordsInOneString.length; i++) {
                if (i % 2 == 1) {
                    if (i == 1) {
                        reversedString += wordsInOneString[i].substring(0, 1).toUpperCase() + wordsInOneString[i].substring(1) + " " + wordsInOneString[0].toLowerCase() + " ";
                    } else if (i == wordsInOneString.length - 1) {
                        reversedString += wordsInOneString[i] + " " + wordsInOneString[i - 1] + ".";
                    } else {
                        reversedString += wordsInOneString[i] + " " + wordsInOneString[i - 1] + " ";
                    }
                }
                if (i == wordsInOneString.length - 1 && wordsInOneString.length % 2 == 1) {
                    reversedString += wordsInOneString[i] + ".";
                }
            }
            sithText += reversedString + " " + randomString.get(new Random().nextInt(randomString.size())) + " ";
        }
        this.sith_text = sithText;
    }

    public String getSith_text() {
        return sith_text;
    }

    public void setSith_text(String sith_text) {
        this.sith_text = sith_text;
    }
}

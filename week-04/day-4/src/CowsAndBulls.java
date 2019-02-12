import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {
    String numberToGuess;
    private String gameState;
    int guessCounter;

    public static void main(String[] args) {
        CowsAndBulls cowsAndBulls = new CowsAndBulls();
        //System.out.println(cowsAndBulls.numberToGuess);
        System.out.println(cowsAndBulls.play());
    }

    public CowsAndBulls() {
        this.numberToGuess = generateRandomNumber();
        this.gameState = "playing";
        System.out.println("I have thought a random four digit number without duplication.");
    }

    public String guess() {
        System.out.println("Please enter your guess:");
        String guessedNumber = String.valueOf(new Scanner(System.in).nextLine());
        int bulls = 0;
        int cows = 0;
        guessCounter++;
        for (int i = 0; i < this.numberToGuess.length(); i++) {
            for (int j = 0; j < this.numberToGuess.length(); j++) {
                if (this.numberToGuess.charAt(i) == guessedNumber.charAt(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        return bulls + " bulls, " + cows + " cows";
    }

    public String play() {
        String guessResult;
        while (this.gameState.equals("playing")) {
            guessResult = this.guess();
            System.out.println(guessResult);
            if (guessResult.equals("4 bulls, 0 cows")) {
                this.gameState = "finished";
            }
        }
        return "Congratulations, you have won!";
    }

    public static String  generateRandomNumber() {
        String randomNumber = "";
        boolean duplicate = true;
        while (duplicate) {
            randomNumber = String.valueOf(new Random().nextInt(9000) + 1000);
            duplicate = hasDuplicates(randomNumber);
        }
        return randomNumber;
    }

    public static boolean hasDuplicates(String randomNumber){
        for(int i = 0; i < randomNumber.length() - 1; i++){
            for(int j = i + 1; j < randomNumber.length(); j ++){
                if(randomNumber.charAt(i) == randomNumber.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}

public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables

        int dailySecondsTotal = 24 * 60 * 60;
        System.out.println("Total seconds in a day: " + dailySecondsTotal);
        int currentSecondsTotal = currentHours * 60 * 60 + currentMinutes * 60 + currentSeconds;
        System.out.println("Current seconds in a day: " + currentSecondsTotal);
        int remainingSecondsTotal = (24 - 1 - currentHours) * 60 * 60 + (60 - 1 - currentMinutes) * 60 + (60-currentSeconds);
        System.out.println("Remaining seconds in a day: " + remainingSecondsTotal);
        int remainingSecondsTotalCheck = dailySecondsTotal - currentSecondsTotal;
        System.out.println("Remaining seconds in a day: " + remainingSecondsTotalCheck);
    }
}

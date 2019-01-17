public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.

        System.out.println(17 * 5 * 6);

        double weeks = 17;
        double workDays = 5;
        double codingHours = 6;

        double codingHoursTotal = weeks * workDays * codingHours;

        System.out.println(codingHoursTotal);

        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        System.out.println((double) (5 * 6) / 52 * 100 + "%");

        double workHours = 52;

        double codingHoursPercentage = codingHoursTotal / (workHours * weeks) * 100;

        System.out.println(codingHoursPercentage + "%");


    }
}

public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";

        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
        // Also, the URL is missing a crutial component, find out what it is and insert it too!
        // Try to solve it more than once using different String functions!

        String url01 = url.replace("bots", "odds");
        url01 = url01.replace("https", "https:");

        System.out.println(url01);

        System.out.println(url.length());

        String url02 = url.substring(0, 4) + ":" + url.substring(5, 38) + "odds";

        System.out.println(url02);



    }
}

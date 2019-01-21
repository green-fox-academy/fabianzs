public class SumAll {
    public static void main(String[] args) {
        // - Create an array variable named `ai`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Print the sum of the elements in `ai`

        int[] ai = {3, 4, 5, 6, 7};
        int sum = 0;

        for (int i = 0; i < ai.length; i++) {
            sum = sum + ai[i];

        }

        System.out.println(sum);

        int sum1 = 0;
        for (int tempSum : ai) {
            sum1 = sum1 +tempSum;
        }
        System.out.println(sum1);
    }
}

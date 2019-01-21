public class Third {
    public static void main(String[] args) {
        // - Create an array variable named `q`
        //   with the following content: `[4, 5, 6, 7]`
        // - Print the third element of `q`

        int[] q = new int[4];

        for (int i = 0; i < q.length; i++) {
            q[i] = 4 + i;
        }

        System.out.println(q[2]);
    }
}

public class LambdaBasics {
    public static void main(String[] args) {
        MyLambda greetingFunction = () -> System.out.print("Hello World!");
        MyMultiply doubleNumberFunction = (int a) -> 2 * a;
        MyTwoIntegerInput addFunction = (int a, int b) -> a + b;
        MyTwoIntegerInput safeDIvideFunction = (int a, int b) -> {
            if (b == 0) {
                return 0;
            }
            return a / b;
        };

        StringLength stringLengthCountFunction = (String s) -> s.length();

    }

    interface MyLambda {
        void sout();
    }

    interface MyMultiply {
        int multiply(int a);
    }

    interface MyTwoIntegerInput {
        int add(int x, int y);
    }

    interface StringLength {
        int count(String s);
    }


}

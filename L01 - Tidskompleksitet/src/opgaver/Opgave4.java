package opgaver;

public class Opgave4 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println(linæreFibo(i));
        }
    }

    public static int linæreFibo(int n) {
        if (n == 0) {
            return n;
        }

        if (n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int nth = 1;
        for (int i = 2; i <= n; i++) {
            nth = first + second;
            first = second;
            second = nth;
        }
        return nth;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

package Recursion;

public class TailFactorialExample {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Tail Factorial of " + n + " is: " + tailFactorial(n, 1));
    }

    public static int tailFactorial(int n, int a) {
        if (n == 0) {
            return a;
        } else {
            return tailFactorial(n - 1, n * a);
        }
    }
}

package com.huseynov.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(28));
        System.out.println(fibonacci(35));

    }

    // 0, 1, 1, 2, 3, 5 ...
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

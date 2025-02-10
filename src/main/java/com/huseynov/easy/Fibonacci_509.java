package com.huseynov.easy;

public class Fibonacci_509 {
    public static void main(String[] args) {
        System.out.println("Enter the number : " + fib(5));
    }

    // Time Complex O(1)
    public static long fib(long n) {
        if (n == 0) {
            return 0;
        } else {
            n--; // f1=1,f2=1 olmasi ucun ;
            double fiveSqrt = Math.sqrt(5);
            double fiboN = 1 / fiveSqrt * (Math.pow(((1 + fiveSqrt) / 2), n + 1)) + 1 / fiveSqrt * (Math.pow(((1 - fiveSqrt) / 2), n + 1));
            if (n % 2 == 0) {
                fiboN++;
            }
            return (long) fiboN;
        }
    }
}

package com.huseynov.recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, 0));
        System.out.println(power(2, 2));
        System.out.println(power(2, 4));
        System.out.println(power(3, 3));
        System.out.println(power(3, 2));
    }

    public static int power(int n, int k) {
        if (k == 0) return 1;
        return n * power(n, k - 1);
    }
}

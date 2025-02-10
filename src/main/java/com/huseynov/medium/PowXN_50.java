package com.huseynov.medium;

public class PowXN_50 {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println("Answer: "+ myPow(x,n));

    }

    public static double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}

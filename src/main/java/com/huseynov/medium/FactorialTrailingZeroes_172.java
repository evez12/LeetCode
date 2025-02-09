package com.huseynov.medium;

//Given an integer n, return the number of trailing zeroes in n!.
//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
public class FactorialTrailingZeroes_172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
    }

    // Problem:
    //Given an integer n, return the number of trailing zeroes in n!.
    //Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
    //Input: n = 3, Output: 0, Explanation: 3! = 6, no trailing zero.
//    Input: n = 5, Output: 1, Explanation: 5! = 120, one trailing zero.
    //Approach:
    // iki ededin hasilinin sonun'da sifir olmaqin isteyirikse, onda ele iki  onda gerek hemin ededlerin bolenlerinin daxilinde 2 ve 5 olmaldir
//    meselen: x = 15, y = 6 => x*y=90; x = 5 * 3, y = 3 * 2 ; x = 10 , y = 7 => x*y=70; x = 2 * 5, y =7; (2 ve 5 mutleq olmalidir;
    public static int trailingZeroes(int n) {
        int count = 0;
        Math.lo

        return count;
    }
}

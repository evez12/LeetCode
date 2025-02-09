package com.huseynov;

public class CountOfMaxDigit {
    public static void main(String[] args) {
        int num1 = 12443;
        int num2 = 124435;
        int num3 = 124434;
        int num4 = 912444;
        System.out.println(num1 + ": "+countOfMaxDigit(num1));
        System.out.println(num2 + ": "+countOfMaxDigit(num2));
        System.out.println(num3 + ": "+countOfMaxDigit(num3));
        System.out.println(num4 + ": "+countOfMaxDigit(num4));
    }

    public static int countOfMaxDigit(int num) {
        int count = 0;
        int[] array = new int[10];
        array[0]=0;
        while (num > 0) {
            int q = num % 10;
            array[q]++;
            num = num / 10;
        }

        count = array[0];
        for (int i = 1; i < 10; i++) {
            if (array[i] > 0){
                count = array[i];
            }
        }

        return count;
    }
}

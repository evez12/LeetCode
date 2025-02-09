package com.huseynov.easy;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int n = 5;
        int[] array = {1, 2, 4, 5};
        System.out.println("Answer: " + findMissingNumber1(array));

    }

    public static int findMissingNumber1(int[] array) {
        int size = array.length;
        int sumN = (size * (size + 1)) / 2;
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray = sumArray + array[i];
        }
        int answer = sumN - sumArray;
        return answer;
    }

    public static int findMissingNumber2(int[] array) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int i = 1; i < array.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}

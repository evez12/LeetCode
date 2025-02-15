package com.huseynov.easy;

public class SquaresOfSortedArray_977 {
    public static void main(String[] args) {
        int[] numbers = {-4, -1, 0, 3, 10};
        for (int i : sortedSquares(numbers)) {
            System.out.print(i + " ");
        }
    }

    public static int[] sortedSquares(int[] numbers) {
        int[] result = new int[numbers.length];
        int index = numbers.length - 1;

        int left = 0, right = numbers.length - 1;
        while (left <= right) {

            if (Math.abs(numbers[left]) > Math.abs(numbers[right])) {
                result[index] = numbers[left] * numbers[left];
                left++;
            } else {
                result[index] = numbers[right] * numbers[right];
                right--;
            }
            index--;

        }
        return result;
    }
}

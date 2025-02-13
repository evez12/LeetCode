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
            int leftSquare = numbers[left] * numbers[left];
            int rightSquare = numbers[right] * numbers[right];
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;

        }
        return result;
    }
}

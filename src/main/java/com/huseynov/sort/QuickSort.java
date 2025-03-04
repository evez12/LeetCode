package com.huseynov.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = {5, 3, 0, 16, 11, 1, 3};
        int[] array2 = {5, 4, 9, 10, 2, 20, 8, 7, 3};
        int[] array3 = {6, 2, 1, 0, 1, 3};
        int[] array4 = {8, 4, 2, 5, 0, 10, 11, 12, 13, 16};
        quickSort(array1, 0, array1.length - 1);
        quickSort(array2, 0, array2.length - 1);
        quickSort(array3, 0, array3.length - 1);
        quickSort(array4, 0, array4.length - 1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] array, int start, int end) {
        int pivot = array[end];
        int index = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (array[i] <= pivot) {
                index++;
                swap(array, index, i);
            }
        }
        swap(array, index + 1, end);
        return index + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

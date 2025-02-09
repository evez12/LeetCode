package com.huseynov.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {2, 3,0,1,11, 1, 5};
        selectionSort(array);
//        System.out.println(minIndex(array,0,3));
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    public static void selectionSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int minIndex = minIndex(array, i, size); // {a,0,5} -> 2
            System.out.println("minIndex: " + minIndex);
            int temp = array[i]; //t=1
            array[i] = array[minIndex]; // a[0] = 1,
            array[minIndex] = temp; // a[2] =
        }
    }

    public static int minIndex(int[] array, int left, int right) {
        int minIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


}

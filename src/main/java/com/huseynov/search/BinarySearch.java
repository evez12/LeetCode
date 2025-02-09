package com.huseynov.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        array = Arrays.stream(array).sorted().toArray();
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        binarySearch(array,10);
        binarySearch(array,1);
        binarySearch(array,0);
        binarySearch(array,2);
        binarySearch(array,5);

    }

    public static void binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid = 0;
        boolean isFound = false;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (array[mid] == target) {
                isFound = true;
                break;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        if (isFound) {
            System.out.println("Element found: " + target + ", index: " + mid);

        } else System.out.println("Not Found: " + target);
    }
}

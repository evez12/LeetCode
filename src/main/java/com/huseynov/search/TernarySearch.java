package com.huseynov.search;

import java.util.Arrays;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        Arrays.sort(array);
        // test case
        ternarySearch(array, 10);
        ternarySearch(array, 1);
        ternarySearch(array, 0);
        ternarySearch(array, 2);
        ternarySearch(array, 5);

    }
    /**
     * Performs a ternary search on a sorted array to find the target element.
     *
     * @param array the sorted array in which to search for the target
     * @param target the element to search for in the array
     */
    public static void ternarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid1 = 0, mid2 = 0;
        boolean isFound = false;

        while (left <= right) {
            mid1 = left + (right - left) / 3;
            mid2 = right - (right - left) / 3;

            if (array[mid1] == target) {
                isFound = true;
                System.out.println("Found element: " + target + ", index: " + mid1);
                break;
            }
            if (array[mid2] == target) {
                isFound = true;
                System.out.println("Found element: " + target + ", index: " + mid2);
                break;
            }

            if (target < array[mid1]) {
                right = mid1 - 1;
            } else if (target > array[mid1] && target < array[mid2]) {
                left = mid1 + 1;
                right = mid2 - 1;
            } else
                left = mid2 + 1;
        }

        if (!isFound) {
            System.out.println("Not found element: " + target);
        }
    }
}

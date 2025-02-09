package com.huseynov.search;

import java.util.Arrays;

public class QuaternarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        Arrays.sort(array);
        // test case
        quaternarySearch(array, 10);
        quaternarySearch(array, 1);
        quaternarySearch(array, 0);
        quaternarySearch(array, 2);
        quaternarySearch(array, 5);

    }


    /**
     * Performs a quaternary search on a sorted array to find the target element.
     *
     * @param array  the sorted array to search
     * @param target the element to search for
     */
    public static void quaternarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid1 = 0, mid2 = 0, mid3 = 0;
        boolean isFound = false;

        while (left <= right) {
            mid1 = left + (right - left) / 4;
            mid2 = right - (right - left) / 2;
            mid3 = right - (right - left) / 4;

            if (array[mid1] == target) {
                isFound = true;
                System.out.println("Found element: " + target + ",index: " + mid1);
                break;
            }
            if (array[mid2] == target) {
                isFound = true;
                System.out.println("Found element: " + target + ",index: " + mid2);
                break;
            }
            if (array[mid3] == target) {
                isFound = true;
                System.out.println("Found element: " + target + ",index: " + mid3);
                break;
            }

            if (target < array[mid1]) {
                right = mid1 - 1;
            } else if (target > array[mid1] && target < array[mid2]) {
                left = mid1 + 1;
                right = mid2 - 1;
            } else if (target > array[mid2] && target < array[mid3]) {
                left = mid2 + 1;
                right = mid3 - 1;
            } else
                left = mid2 + 1;
        }

        if (!isFound) {
            System.out.println("Not found element: " + target);
        }
    }
}

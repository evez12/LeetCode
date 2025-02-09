package com.huseynov.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        linearSearch(array,12);
        linearSearch(array,1);
        linearSearch(array,2);

    }

    public static void linearSearch(int[] array, int target) {
        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            System.out.println("Element found : " + target);
        } else {
            System.out.println("Not found: " + target);
        }
    }

}

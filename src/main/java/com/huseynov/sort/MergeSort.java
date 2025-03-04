package com.huseynov.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1, 8, 6, 5, 6, 1, 4, 8, 9};
        int[] arr2 = {7, 0, 0, 9, 11, 3, 8, 9, 11};
        int[] sorted = {5, 6, 7, 8, 9, 11, 11, 11, 1, 2, 3, 4};
        sort2(arr1, 0, arr1.length - 1);

        System.out.println("Sorted array is: " + Arrays.toString(arr1));
        System.out.println();
    }

    // method 1
    public static int[] sort1(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        int[] left = sort1(Arrays.stream(arr).limit(mid).toArray());
        int[] right = sort1(Arrays.stream(arr).skip(mid).toArray());
        return merge1(left, right);
    }

    public static int[] merge1(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];

            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];

        }
        while (j < b.length) {
            c[k++] = b[j++];

        }
        return c;
    }

    // method2
    public static void sort2(int[] arr, int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            sort2(arr, l, m);
            sort2(arr, m + 1, r);

            merge2(arr, l, m, r);
        }

    }

    public static void merge2(int[] arr, int l, int m, int r) {
        int sizeL = m - l + 1;
        int sizeR = r - m;

        int leftArray[] = new int[sizeL];
        int rightArray[] = new int[sizeR];

        for (int i = 0; i < sizeL; ++i)
            leftArray[i] = arr[l + i];

        for (int j = 0; j < sizeR; ++j)
            rightArray[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < sizeL && j < sizeR) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < sizeL) {
            arr[k++] = leftArray[i++];
        }

        while (j < sizeR) {
            arr[k++] = rightArray[j++];
        }
    }
}

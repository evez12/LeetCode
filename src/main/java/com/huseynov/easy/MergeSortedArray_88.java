package com.huseynov.easy;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        mergeWithExtraMemory(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums3 = {1, 3, 4, 0, 0}, nums4 = {0, 2};
        mergeWithExtraMemory(nums3, 3, nums4, 2);
        for (int i : nums3) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums5 = {1}, nums6 = {};
        mergeWithExtraMemory(nums5, 1, nums6, 0);
        for (int i : nums5) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums7 = {0}, nums8 = {1};
        mergeWithExtraMemory(nums7, 0, nums8, 1);
        for (int i : nums7) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums9 = {0, 6, 0, 0, 0, 0, 0, 0}, nums10 = {1, 2, 4, 5, 9, 11};
        mergeWithExtraMemory(nums9, 2, nums10, 6);
        for (int i : nums9) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums11 = {1, 2, 3, 0, 0, 0}, nums22 = {4, 5, 6};
        mergeWithExtraMemory(nums11, 3, nums22, 3);
        for (int i : nums11) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //  Time complexity O(n+m), Space complexity O(n+m)
    public static void mergeWithExtraMemory(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        if (n == 0) {
            return;
        }
        int[] array = new int[m + n];
        int indexM = 0, indexN = 0, i = 0;
        while (indexM < m || indexN < n) {

            if (indexM < m && indexN < n) {
                if (nums1[indexM] > nums2[indexN]) {
                    array[i++] = nums2[indexN++];
                } else {
                    array[i++] = nums1[indexM++];
                }
            } else if (indexM < m) {
                array[i++] = nums1[indexM++];
            } else {
                array[i++] = nums2[indexN++];
            }

        }
        System.arraycopy(array, 0, nums1, 0, array.length);
    }

    //  Time complexity O( nlog(n) ), Space complexity O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    //  Time complexity O(n), Space complexity O(1)
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        // TODO

        }

}

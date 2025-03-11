package easy;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        test();
    }


    //  Time complexity O( nlog(n) ), Space complexity O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    //  Time complexity O(n+m), Space complexity O(1)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        // Compare elements from the end of both arrays and merge them into nums1
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        // If there are remaining elements in nums1, copy them
        while (index1 >= 0) {
            nums1[index--] = nums1[index1--];
        }
        // If there are remaining elements in nums2, copy them
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }

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


    private static void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
//        mergeWithExtraMemory(nums1, 3, nums2, 3);
        merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1, 3, 4, 0, 0}, nums4 = {0, 2};
//        mergeWithExtraMemory(nums3, 3, nums4, 2);
        merge1(nums3, 3, nums4, 2);
        System.out.println(Arrays.toString(nums3));

        int[] nums5 = {1}, nums6 = {};
//        mergeWithExtraMemory(nums5, 1, nums6, 0);
        merge1(nums5, 1, nums6, 0);
        System.out.println(Arrays.toString(nums5));

        int[] nums7 = {0}, nums8 = {1};
//        mergeWithExtraMemory(nums7, 0, nums8, 1);
        merge1(nums7, 0, nums8, 1);
        System.out.println(Arrays.toString(nums7));

        int[] nums9 = {0, 6, 0, 0, 0, 0, 0, 0}, nums10 = {1, 2, 4, 5, 9, 11};
//        mergeWithExtraMemory(nums9, 2, nums10, 6);
        merge1(nums9, 2, nums10, 6);
        System.out.println(Arrays.toString(nums9));

        int[] nums11 = {1, 2, 3, 0, 0, 0}, nums22 = {4, 5, 6};
//        mergeWithExtraMemory(nums11, 3, nums22, 3);
        merge1(nums11, 3, nums22, 3);
        System.out.println(Arrays.toString(nums11));
    }
}

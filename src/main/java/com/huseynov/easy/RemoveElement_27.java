package com.huseynov.easy;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));
        for (int num : nums2) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] nums3 = {4, 4, 0, 1, 0, 2};
        System.out.println(removeElement(nums3, 0));
        for (int num : nums3) {
            System.out.print(num + " ");
        }

    }

    /**
     * Constraints:
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */
    public static int removeElement(int[] nums, int value) {
        int size = nums.length;
        int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {

            if (value == nums[i]) {
                nums[i] = nums[lastIndex];
                nums[lastIndex] = -1;
                lastIndex--;
                i--;
            }
        }
        return lastIndex + 1;
    }
}

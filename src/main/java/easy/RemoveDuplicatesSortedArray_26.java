package easy;

public class RemoveDuplicatesSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
//        System.out.println(removeDuplicates(nums));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums2));
    }

    /**
     * Constraints:
     * 1 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     */

    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int left = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[left] = nums[i];
                left++;
            }
        }

        return left;
    }
}

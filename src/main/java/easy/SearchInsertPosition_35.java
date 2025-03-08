package easy;

public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));

        int[] nums2 = {1, 3, 5, 6};
        System.out.println(searchInsert(nums2, 2));

        int[] nums3 = {1, 3, 5, 6};
        System.out.println(searchInsert(nums3, 7));

        int[] nums4 = {1, 3, 5, 6};
        System.out.println(searchInsert(nums4, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

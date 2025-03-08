package medium;

public class FindMinimumRotatedSortedArray_153 {
    public static void main(String[] args) {
        int[] numbers3 = {4, 5, 6, 7, 0};
        findMin(numbers3);

        int[] numbers4 = {7, 0, 1, 2, 3, 4};
        findMin(numbers4);

        int[] numbers5 = {3, 4, 5, 1, 2};
        findMin(numbers5);

        int[] numbers6 = {11, 13, 15, 17};
        findMin(numbers6);
    }

    private static int findMin(int[] nums) {
        int firstElement = nums[0];
        int brokenIndex = 0;
        int size = nums.length;
        int left = 0, right = size - 1, mid;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if ((mid > 0 && nums[mid - 1] > nums[mid])) {
                brokenIndex = mid;
                break;
            }
            if (mid < size - 1 && nums[mid + 1] < nums[mid]) {
                brokenIndex = mid + 1;
                break;
            }
            if (nums[mid] > firstElement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Broken index: " + (nums[brokenIndex]));
        return 0;
    }
}

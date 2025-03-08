package medium;

public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(numbers, 0));
//        System.out.println(findBrokenIndex(numbers));
//
        int[] numbers2 = {2, 3, 4, 5, 6, 7};
        System.out.println(search(numbers2, 0));
//        System.out.println(findBrokenIndex(numbers2));
//
//
        int[] numbers3 = {4, 5, 6, 7, 0};
        System.out.println(search(numbers3, 0));
//        System.out.println(findBrokenIndex(numbers3));
//
        int[] numbers4 = {7, 0, 1, 2, 3, 4};
//        System.out.println(findBrokenIndex(numbers4));
        System.out.println(search(numbers4, 0));

        int[] numbers5 = {5,1,3};
        System.out.println(search(numbers5, 1));
//        System.out.println(findBrokenIndex(numbers5));
    }

    public static int search(int[] nums, int target) {
//        4,5,6,7,0,1,2  =>  broken index is 3. (...6,7,0...)
//        7,1,2,3,4 => broken index is 0.
        int brokenIndex = findBrokenIndex(nums);
        if (brokenIndex == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[0] == target) {
            return 0;
        } else if (nums[0] > target) {
            return binarySearch(nums, brokenIndex + 1, nums.length - 1, target);
        } else return binarySearch(nums, 0, brokenIndex, target);

    }

    public static int binarySearch(int[] array, int left, int right, int target) {
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return -1; // if not found
    }

    private static int findBrokenIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid-1;
            }
            if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // no broken ,array have sorted
    }

}


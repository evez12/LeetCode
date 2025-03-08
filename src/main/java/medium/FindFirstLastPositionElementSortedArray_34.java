package medium;

public class FindFirstLastPositionElementSortedArray_34 {
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        for (int i : searchRange(nums1, 8)) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        for (int i : searchRange(nums2, 6)) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] nums3 = {};
        for (int i : searchRange(nums3, 0)) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] nums4 = {8, 8, 8, 8, 8};
        for (int i : searchRange(nums4, 8)) {
            System.out.print(i + " ");
        }

    }


    public static int[] searchRange(int[] numbers, int target) {
        int[] answer = {-1, -1};
        int index = binarySearch(numbers, target);
        if (index == -1) return answer;

        int left = index, right = index;
        boolean hasLeft = true, hasRight = true;
        while (hasLeft || hasRight) {
            if (left > 0 && numbers[left - 1] == target) left--;
            else hasLeft = false;

            if (right < numbers.length - 1 && numbers[right + 1] == target) right++;
            else hasRight = false;
        }
        answer[0] = left;
        answer[1] = right;
        return answer;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

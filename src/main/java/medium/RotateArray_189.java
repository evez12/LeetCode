package medium;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        rotate3(nums1, 1);
        for (int i : nums1) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        rotate3(nums2, 3);

        for (int i : nums2) {
            System.out.print(i + " ");
        }
    }

    // Time Complexity O(n) , Space Complexity O(1)
    // 1, 2, 3, 4,|5, 6, 7  , k =3;
    // step 1: 7, 6, 5|, 4, 3, 2, 1;  reverse nums
    // step 2: 5, 6, 7|, 4, 3, 2, 1;  reverse first k element
    // step 3: 5, 6, 7|, 1, 2, 3, 4;  reverse other elements
    public static void rotate3(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        if (size == 1 || k == 0) return;
        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);

    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    // Time Complexity => O(n) , Space Complexity => O(n)
    public static void rotate2(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        if (size == 1 || k == 0) return;

        int[] array = new int[size];
        int j = 0;

        for (int i = 0; i < size; i++) {
            if (i >= k) {
                array[i] = nums[j++];
                continue;
            }
            array[i] = nums[size - k + i];
        }

        System.arraycopy(array, 0, nums, 0, size);

    }


    // Time complexity O(n * k), Space complexity O(1)
    public static void rotate1(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        if (size == 1 || k == 0) return;

        for (int i = 0; i < k; i++) {
            rotateOnce(nums);
        }
    }

    private static void rotateOnce(int[] nums) {
        int size = nums.length;
        int current = nums[0];
        int next = 0;
        for (int i = 0; i < size - 1; i++) {
            next = nums[i + 1];
            nums[i + 1] = current;
            current = next;
        }
        nums[0] = next;
    }
}

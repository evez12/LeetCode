package easy;

import java.util.Scanner;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        moveZeroes(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    // Time Complexity O(n), Space Complexity O(1)
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        int right;
        int left = size;
        // Find the first zero
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                left = i;
                break;
            }
        }
        right = left + 1;
        while (right < size) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

}

package medium;

import java.util.Arrays;

public class ProductArrayExceptSelf_238 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6};
        int[] ints = productExceptSelf2(arr);
        System.out.println(Arrays.toString(ints));
    }

    // Time complexity O(n) , Space complexity O(n);
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        int[] pre = new int[size + 1];
        pre[0] = 1;
        int[] suf = new int[size + 1];
        suf[0] = 1;
        for (int i = 0; i < size; i++) {
            pre[i + 1] = pre[i] * nums[i];
            suf[i + 1] = suf[i] * nums[size - i - 1];
        }
        for (int i = 0; i < size; i++) {
            ans[i] = pre[i] * suf[size - i - 1];
        }
        return ans;
    }

    // Time complexity O(n) , Space complexity O(1);
    public static int[] productExceptSelf2(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        ans[0] = 1;

        for (int i = 1; i < size; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(ans));
        int multiplication = 1;
        for (int i = size - 2; i >= 0; i--) {
            multiplication *= nums[i + 1];
            ans[i] = ans[i] * multiplication;
        }

        return ans;
    }

}

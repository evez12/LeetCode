package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};

        System.out.println(longestSequences(nums1));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestSequences(nums2));
    }

    public static int longestSequences(int[] nums) {
        int count = 0;
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        //
        for (int i = 0; i < nums.length; i++) {
            int eachCount = 1;
            int value = nums[i] - 1;
            while (map.contains(value)) {
                eachCount++;
                map.remove(value);
                value--;
            }
            value = nums[i] + 1;
            while (map.contains(value)) {
                eachCount++;
                map.remove(value);
                value++;
            }
            map.remove(nums[i]);
            count = Math.max(count,eachCount);

        }
        return count;
    }
}

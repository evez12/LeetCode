package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
        int[] nums1 = {1, 0, 1, 1};
        int k1 = 1;
        System.out.println(containsNearbyDuplicate(nums1, k1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        return false;

    }
}

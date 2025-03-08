package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange_228 {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums1));
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
//        System.out.println(summaryRanges(nums2));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        String range;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1]) != nums[i] - 1) {
//                System.out.println("i: " + i);
                if (nums[start] == nums[i - 1]) {
                    range = nums[start] + "";
                    start = i;
                } else {
                    range = nums[start] + "->" + nums[i - 1];
                    start = i;
                }
                result.add(range);
                range = "";
            }
        }
        if (start == nums.length - 1) {
            result.add(nums[start] + "");
        } else {
            result.add(nums[start] + "->" + nums[nums.length - 1]);
        }
        return result;
    }
}

package com.huseynov.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement1(nums1));

        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums2));

    }

    // Time complexity O(n), Space complexity O(1)
    public static int majorityElement1(int[] nums) {
        int size = nums.length;

        if (size == 1) return nums[0];

        int count = 1;
        int answer = nums[0];
        for (int i = 1; i < size; i++) {

            if(answer != nums[i]){
                count--;
            }
            else{
                count++;
            }

            if(count == 0){
                answer = nums[i];
                count =1;
            }
        }
        return answer;
    }
    // Time complexity O(n), Space complexity O(n)
    public static int majorityElement2(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int answer = 0;
        for (int i = 0; i < size; i++) {

            if (map.containsKey(nums[i])) {
                int frequency = map.get(nums[i]) + 1;
                map.put(nums[i], frequency);
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    answer = nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return answer;
    }
}


package com.huseynov.easy;

import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {
        int target = 9;
        int[] array1 = {2, 7, 11, 15};
        int[] array2 = {3, 2, 4};

//        int[] ints1 = twoSum(array1, target);
//        for (int anInt : ints1) System.out.print(anInt + " ");

//        System.out.println("\n");

        int[] ints2 = twoSum(array2, 6);
        for (int anInt : ints2) System.out.print(anInt + " ");

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerHashMap.put(nums[i], i);
        }


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (integerHashMap.containsKey(diff) && i != integerHashMap.get(diff)) {
                answer[0] = i;
                answer[1] = integerHashMap.get(diff);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (integerHashMap.containsKey(diff) && integerHashMap.get(diff) != i) {
                return new int[]{i, integerHashMap.get(diff)};
            }
        }
        return answer;
    }
}

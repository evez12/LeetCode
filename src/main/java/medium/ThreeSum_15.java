package medium;

import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {

//        test();
        int[] nums4 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
//        System.out.println("nums4: " + threeSum(nums4));
        threeSum(nums4);
        Arrays.sort(nums4);

        for (int i : nums4) {
//            System.out.print(i+" ");
        }
    }

    // -4, -1, -1, 0 , 1, 2
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int size = nums.length;
        HashSet<List<Integer>> listHashSet = new HashSet<>(); // for [1,1,0], [0,1,1]  same
        for (int i = 0; i < size; i++) {
            int target;
            target = -nums[i]; // because num[i] + target = 0
            int[] twoSumValue = twoSum(nums, target, i);
            if (twoSumValue.length > 1) { // if target not found then twoSum() return "int[] n = {1}" else return n[2]={nums[j], nums[k]};
                List<Integer> findSum = new ArrayList<>();
                findSum.add(nums[i]);
                findSum.add(twoSumValue[0]); // twoSumValue[2] = {nums[j], nums[k]}
                findSum.add(twoSumValue[1]);
                Collections.sort(findSum);
                if (!listHashSet.contains(findSum)){
                    answer.add(findSum);
                    listHashSet.add(findSum);
                }
            }
        }
        System.out.println("Answer: "+answer);
        System.out.println("Hasp: "+listHashSet);
//        answer.addAll(listHashSet);
        return answer;
    }
    // for sorted array. return two number

    public static int[] twoSum(int[] numbers, int target, int usedIndex) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            int rightNumber = numbers[right];
            int leftNumber = numbers[left];
            if ((rightNumber + leftNumber) > target) {
                right--;
            } else if ((rightNumber + leftNumber) == target) {
                if (right != usedIndex) {  // i!=r
                    if (left != usedIndex) {
                        int[] answer = {leftNumber, rightNumber}; // return value
                        return answer;
                    } else {
                        left++;
                    }
                } else {
                    right--;
                }
            } else { //(rightNumber + leftNumber) < target
                left++;
            }
        }
        return new int[]{-1};
    }
    private static void test() {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("nums1: " + threeSum(nums1));

        int[] nums2 = {0, 1, 1};
        System.out.println("nums2: " + threeSum(nums2));

        int[] nums3 = {0, 0, 0};
        System.out.println("nums3: " + threeSum(nums3));

        int[] nums4 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("nums4: " + threeSum(nums4));
    }
}

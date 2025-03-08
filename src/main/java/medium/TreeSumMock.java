package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSumMock {
    public class ThreeSum_15 {
        public static void main(String[] args) {
            int[] nums1 = {-1, 0, 1, 2, -1, -4};
            System.out.println("nums1: " + threeSum(nums1));

        }

        // -4, -1, -1, 0 , 1, 2
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            List<List<Integer>> answer = new ArrayList<>();
            int usedValue = (int) Math.pow(10, 5) + 1; // if any number used then it's value update 10**5 + 1 for future I must not be used this number (because num[i] < 10**5 for Constraints)
            int size = nums.length;

            for (int i = 0; i < size; i++) {
                System.out.println("i: " + i);
                int target;
                if (nums[i] != usedValue) {
                    target = -nums[i]; // because num[i] + target = 0
                    int[] twoSumValue = twoSum(nums, target, i);
                    System.out.print("TwoSumValue length: " + twoSumValue.length + ",values: ");
                    for (int i1 : twoSumValue) {
                        System.out.print(i1 + " ");
                    }
                    System.out.println();
                    if (twoSumValue.length > 1) { // if target not found then twoSum() return "int[] n = {1}" else return n[4]={nums[j], nums[k], j, k};
                        List<Integer> findSum = new ArrayList<>();
                        findSum.add(nums[i]);
                        findSum.add(twoSumValue[0]); // twoSumValue[4] = {nums[j], nums[k], j, k}
                        findSum.add(twoSumValue[1]);
                        int j = twoSumValue[2];
                        int k = twoSumValue[3];
                        nums[i] = usedValue; // have used value
                        nums[j] = usedValue;
                        nums[k] = usedValue;
                        answer.add(findSum);
                    }
                }
            }
            return answer;
        }

        // for sorted array. return two number and its index
        public static int[] twoSum(int[] numbers, int target, int usedIndex) {
            int left = 0, right = numbers.length - 1;
            int usedValue = (int) Math.pow(10, 5) + 1; // if any number used then it's value update 10**5 + 1 (because num[i] < 10**5 for Constraints)
            while (right > left) {
                int rightNumber = numbers[right];
                int leftNumber = numbers[left];
                if ((rightNumber + leftNumber) > target) {
                    right--;
                } else if ((rightNumber + leftNumber) == target) {
                    if ((right != usedIndex && left != usedIndex) && (rightNumber != usedValue && leftNumber != usedValue)) {  // if nums[right] used then it's value equal usedValue
                        int[] answer = {leftNumber, rightNumber, left, right}; // return value and index
                        return answer;
                    } else {
                        right--;
                        left++;
                    }
                } else { //(rightNumber + leftNumber) < target
                    left++;
                }
            }
            return new int[]{-1};
        }
    }
}

package com.huseynov.medium;

public class TwoSum2InputArrayIsSorted_167 {
    public static void main(String[] args) {
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.print("numbers1: ");
        for (int i : twoSum(numbers1, target1)) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] numbers2 = {2,3,4};
        int target2 = 6;
        System.out.print("numbers2: ");
        for (int i : twoSum(numbers2, target2)) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        System.out.print("numbers3: ");
        for (int i : twoSum(numbers3, target3)) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] numbers4 = {1,2,3,4};
        int target4 = 3;
        System.out.print("numbers4: ");
        for (int i : twoSum(numbers4, target4)) {
            System.out.print(i + " ");
        }


    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            int rightNumber = numbers[right];
            int leftNumber = numbers[left];
            if ((rightNumber + leftNumber) > target) {
                right--;
            } else if ((rightNumber + leftNumber) == target) {
                int[] answer = {left + 1,right + 1}; //
                return answer;
            } else { //(rightNumber + leftNumber) < target
                left++;
            }
        }
        return new int[]{-1};
    }
}

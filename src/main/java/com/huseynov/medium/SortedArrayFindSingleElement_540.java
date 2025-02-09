package com.huseynov.medium;

public class SortedArrayFindSingleElement_540 {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] array2 = {3, 3, 7, 7, 10, 11, 11};
        int[] array3 = {1};
        int[] array4 = {1, 1, 2, 2, 3};
        System.out.println("Answer1: " + singleNonDuplicate(array1));
        System.out.println("Answer2: " + singleNonDuplicate(array2));
        System.out.println("Answer3: " + singleNonDuplicate(array3));
        System.out.println("Answer4: " + singleNonDuplicate(array4));

    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, size = nums.length, right = size - 1;
        int mid = 0, countOfElement = 0, answer = nums[left];

//     array'in birinci elmenti olarsa (answer)
        if (size == 1 || nums[0] != nums[1]) {
            return nums[0];
        }

        while (left <= right) {
            mid = left + (right - left) / 2;

            // array sonuncu elementi olarsa
            if (mid == size - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            countOfElement = size - mid - 1;// sagindaki element ozune berarber ve sagdaki elementlerin sayi tekdirse onda answer sagdadir
            if (nums[mid] == nums[mid + 1] && countOfElement % 2 == 0) {
                left = mid + 1;
            }
            else if (nums[mid] == nums[mid - 1] && countOfElement % 2 == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

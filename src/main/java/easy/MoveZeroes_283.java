package easy;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        int right;
        int left = size;
        for (int i=0; i < size; i++){
            if(nums[i] == 0){
                left = i;
                break;
            }
        }
        right = left +1;
        while( right < size ){

            if(nums[left] == 0 && nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
    
}

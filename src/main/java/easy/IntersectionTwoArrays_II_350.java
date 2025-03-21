package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionTwoArrays_II_350 {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int max = Arrays.stream(nums1).max().getAsInt();
        int[] counter = new int[max + 1];
        ArrayList<Integer> result = new ArrayList<>();

        for (int n : nums1) {
            counter[n]++;
        }

        for (int n : nums2) {
            if (n <= max && counter[n] > 0) {
                result.add(n);
                counter[n]--;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

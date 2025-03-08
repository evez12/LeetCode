package medium;

import java.util.HashMap;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] nums2 = {1};
        int k2 = 1;
        int[] nums3 = {1, 2, 2, 3, 3, 3};
        int k3 = 2;
        int[] nums4 = {7, 7};
        int k4 = 1;
//        print(topKFrequent(nums1, k1));
//        print(topKFrequent(nums2, k2));
//        print(topKFrequent(nums3, k3));
//        print(topKFrequent(nums4, k4));
        topKFrequent(nums1, k1);
        topKFrequent(nums2, k2);
        topKFrequent(nums3, k3);
        topKFrequent(nums4, k4);
    }

    public static int[] topKFrequent(int[] array, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        int newValue = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            answer[j++] = array[i];
            if (integerHashMap.containsKey(array[i])) {
                int incrementValue = integerHashMap.get(array[i]) + 1;
                integerHashMap.put(array[i], incrementValue);
            } else {
                integerHashMap.put(array[i], 1);
            }

            newValue = integerHashMap.get(array[i]);
        }
        return answer;
    }

    private static void print(int[] ints) {
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println("\n");
    }
}

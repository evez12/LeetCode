package medium;

import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int[] nums1 = {2, 2, 4, 4, 0, 1, 1, 2, 2, 3, 3, 3};
//        int[] nums1 = {-1, -1};
        int k1 = 2;
        int[] nums2 = {1, 2};
        int k2 = 1;
        int[] nums3 = {1, 2, 2, 3, 3, 3};
        int k3 = 2;
        int[] nums4 = {7, 7};
        int k4 = 1;
//        print(topKFrequent(nums1, k1));
//        print(topKFrequent(nums2, k2));
//        print(topKFrequent(nums3, k3));
//        print(topKFrequent(nums4, k4));
        topKFrequent2(nums1, 4);
//        topKFrequent(nums2, k2);
//        topKFrequent(nums3, k3);
//        topKFrequent(nums4, k4);
    }


    // 1. Solution
    // Time complexity: O(nlogn), Space complexity: O(n);
    public static int[] topKFrequent(int[] array, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : array) {
            if (counter.containsKey(num)) {
                int incrementValue = counter.get(num) + 1;
                counter.put(num, incrementValue);
            } else {
                counter.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(counter.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<Integer, Integer> entry : list) {
            answer[k - 1] = entry.getKey();
            k--;
            if (k == 0) break;
        }
        return answer;
    }

    // 2. Solution
    // Time complexity: O(n), Space complexity: O(n);
    public static int[] topKFrequent2(int[] array, int k) {
        int[] answer = new int[k];
        int size = array.length;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : array) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

//        System.out.println(counter);
        List<List<Integer>> buckets = new ArrayList<>(size + 1);

        for (int i = 0; i <= size; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

//        System.out.println(buckets);
        for (int i = size; i >= 0; i--) {
            if (!buckets.get(i).isEmpty()) {
                for (Integer num : buckets.get(i)) {
                    answer[k - 1] = num;
                    k--;
                }
            }
            if (k == 0) break;
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

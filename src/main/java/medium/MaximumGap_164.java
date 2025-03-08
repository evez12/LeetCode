package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MaximumGap_164 {
    public static void main(String[] args) {
        int[] arr1 = {3, 6, 9, 1};
        System.out.println("result: " + maximumGap(arr1));
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2, 99999999};
        System.out.println("result: " + maximumGap(arr2));
        System.out.println(Arrays.toString(arr2));
    }

    public static int maximumGap(int[] array) {
        if (array.length <= 1) return 0;
        int max = Arrays.stream(array).max().getAsInt();
        int n = digitCount(max); // 8

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>(10);

        for (int i = 1; i <= n; i++) {
            for (int num : array) {
                int digit = getDigit(num, i);
                if (digit == 0 || digit == -1) {
                    if (!map.containsKey(0)) {
                        map.put(0, new LinkedList<>());
                    }
                    map.get(0).push(num);
                } else {
                    if (!map.containsKey(digit)) {
                        map.put(digit, new LinkedList<>());
                    }
                    map.get(digit).push(num);
                }
            }

            insert(array, map);
        }

        int result = Math.abs(array[0] - array[1]);
        for (int i = 1; i < array.length - 1; i++) {
            int diff = Math.abs(array[i] - array[i + 1]);
            if (diff > result) result = diff;
        }

        return result;
    }

    public static void insert(int[] array, HashMap<Integer, LinkedList<Integer>> map) {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(i)) {
                LinkedList<Integer> numbers = map.get(i);
                while (!numbers.isEmpty()) {
                    array[k++] = numbers.pollLast();
                }
            }
        }
    }

    public static int getDigit(int n, int d) {
        if (d > digitCount(n)) return -1;
        n = Math.abs(n);
        return (n / (int) Math.pow(10, d - 1)) % 10;
    }

    public static int digitCount(int max) {
        if (max == 0) return 1;
        max = Math.abs(max);
        return (int) Math.log10(max) + 1;
    }
}

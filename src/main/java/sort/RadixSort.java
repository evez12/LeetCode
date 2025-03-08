package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 10, 22, 1, 5, 0, 1, 1, 2, 3};
        int[] array2 = {1556, 4, 3556, 593, 408, 4386, 902, 7, 8157, 86, 9637, 29};
        int[] array3 = {1, 11, 2, 5, 9, 3, 0, 1, 3};
        int[] array4 = {0, 0, 1};
        int[] array5 = {90, 93, 4, 6, 56, 46, 86, 81, 967, 408, 29};
        radixSort(array);
        radixSort(array2);
        radixSort(array3);
        radixSort(array4);
        radixSort(array5);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));

    }


    // Time Complexity O(n*k), Space Complexity O(n+k)  (note: k => max digit count)
    public static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int n = digitCount(max);

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

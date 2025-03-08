package medium;

import java.util.Arrays;

public class H_Index_274 {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("Result: " + hIndex1(citations1));

        int[] citations2 = {1, 3, 1};
        System.out.println("Result: " + hIndex1(citations2));
//
        int[] citations3 = {4, 4, 4, 4};
        System.out.println("Result: " + hIndex1(citations3));
//
        int[] citations4 = {10, 8, 5, 4, 3};
        System.out.println("Result: " + hIndex1(citations4));

        int[] citations5 = {0, 3, 5, 7, 8, 9, 12};
        System.out.println("Result: " + hIndex1(citations5));
    }


    public static int hIndex2(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();
        int[] counter = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            counter[citations[i]]++;
        }
        int tempCounter = 0;
        for (int i = max; i >= 0; i--) {

            tempCounter += counter[i];
            if (i <= tempCounter) {
                return i;
            }

        }
        return 0;
    }

    public static int hIndex1(int[] citations) {
        int size = citations.length;
        int[] counter = new int[size + 1];
        for (int i = 0; i < citations.length; i++) {

            if (citations[i] >= size) {
                counter[size]++;
            } else {
                counter[citations[i]]++;
            }
        }
        int tempCounter = 0;
        for (int i = size; i >= 0; i--) {

            tempCounter += counter[i];
            if (i <= tempCounter) {
                return i;
            }
        }
        return 0;
    }
}

package sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 10, 22, 1, 5, 0, 1, 1, 2, 3};
        int size = array.length;
        System.out.println(Arrays.toString(array));

        int max = Arrays.stream(array).max().getAsInt();
//        System.out.println("max:" + max);

        int[] helper = new int[max + 1];
        for (int i = 0; i < size; i++) {
            helper[array[i]]++;
        }
        for (int j = 0; j < max+1 ; j ++) {
            for (int i = 0; i < helper[j]; i++) {
                System.out.print(j + " ");
            }
        }

        System.out.println();
        System.out.println();
        for (int k : helper) {
            System.out.print(k + " ");
        }
    }
}

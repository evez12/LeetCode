package recursion;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4, 10};
        int[] arr3 = {1, 2, 6, 7, 8, 9};
        int[] arr4 = {2, 5, 6, 9};
        int[] arr5 = {1, 0, 5, 6, 9};
//        Arrays.stream(arr1).skip(1).forEach(System.out::print);

        System.out.println(productArray(arr1));
        System.out.println(productArray(arr2));
        System.out.println(productArray(arr3));
        System.out.println(productArray(arr4));
        System.out.println(productArray(arr5));

    }

    public static int productArray(int[] numbers) {

        if (numbers.length == 0) return 1;

        return numbers[0] * productArray(Arrays.stream(numbers).skip(1).toArray());
    }
}

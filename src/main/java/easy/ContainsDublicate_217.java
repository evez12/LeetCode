package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDublicate_217 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1};
        System.out.println("Array1: " + containsDuplicate1(array1));


    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>();
        for (int number : nums) {
            if (numbersSet.contains(number)) {
                return true;
            }
            numbersSet.add(number);
        }
        return false;
    }


}

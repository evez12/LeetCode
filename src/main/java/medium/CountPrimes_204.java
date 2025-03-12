package medium;

import java.util.Arrays;

public class CountPrimes_204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // Output: 7
//        System.out.println(countPrimes(0));  // Output: 0
//        System.out.println(countPrimes(1));  // Output: 0
//        System.out.println(countPrimes(2));  // Output: 0
//        System.out.println(countPrimes(3));  // Output: 1
    }


    public static int countPrimes(int n) {
        int count = 0;
        boolean[] counter = new boolean[n];
        Arrays.fill(counter, true);

        for (int i = 2; i < n; i++) {

            if (counter[i]) {
                setCounter(counter, i);
            }
        }
        for (int i = 2; i < n; i++) {
            if (counter[i]) count++;
        }
        return count;
    }

    private static void setCounter(boolean[] counter, int i) {
        for (int j = i * 2; j < counter.length; j += i) {
            counter[j] = false;
        }
    }

}

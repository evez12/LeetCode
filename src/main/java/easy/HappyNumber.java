package easy;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
//        System.out.println("19: " + isHappyNumber(19));
        System.out.println("2: " + isHappyNumber(2));
    }

    public static boolean isHappyNumber(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int digitSqrt = 0;
        while (n != 1) {
            digitSqrt = sumDigitSqrt(n);

            if (hashSet.contains(digitSqrt)) {
//                System.out.println("DigirSQRT: "+digitSqrt);
//                System.out.println(hashSet);
                return false;
            } else {
                hashSet.add(digitSqrt);
            }
            n = digitSqrt;
        }
        return true;
    }

    public static int sumDigitSqrt(int n) {
        double sum = 0;
        while (n > 0) {
            double digit = n % 10;
            sum = sum + Math.pow(digit, 2);
            n = n / 10;
        }
        return (int) sum;
    }
}

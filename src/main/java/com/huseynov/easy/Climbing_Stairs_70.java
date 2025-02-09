package com.huseynov.easy;

public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        System.out.println("Enter the number : " + climbingStairs(6));
    }

//    version 1
//    Time Complexity O(n)
    public static long climbingStairs(int n) {
        long stepsCount = 0, step1 = 0, step2 = 1;
        for (int i = 0; i <= n + 1; i++) {
            stepsCount = stepsCount + step1;
            step1 = step2;
            step2 = stepsCount;
        }
        return stepsCount;
    }

//    version 2
//    Time Complexity O(1)
    public static long climbingStairs2(long n) {
        double stepsCount;
        double fiveSqrt = Math.sqrt(5);
        stepsCount = 1 / fiveSqrt * (Math.pow(((1 + fiveSqrt) / 2), n + 1)) + 1 / fiveSqrt * (Math.pow(((1 - fiveSqrt) / 2), n + 1));
        if (n % 2 == 0) {
            stepsCount++;
        }
        return (long) stepsCount;
    }
}

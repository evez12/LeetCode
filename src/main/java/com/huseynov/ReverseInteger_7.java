package com.huseynov;

public class ReverseInteger_7 {
    public static void main(String[] args) {
        System.out.println("Enter the number : " + reverse(123));
        System.out.println("Enter the number : " + reverse(100));
        System.out.println("Enter the number : " + reverse(-123));
        System.out.println("Enter the number : " + reverse(120));
        System.out.println("Enter the number : " + reverse(554362));
//        System.out.println("Enter the number : " + 123 / 10);
//        System.out.println("Enter the number : " + 123 % 10);


    }

    public static int reverse(int x) {
        int myx = Math.abs(x);
        long results = 0 ;

        while (myx > 0) {
            int temp = myx % 10;
            myx = myx / 10;
            results = results * 10 + temp;
        }

        if (results > Integer.MAX_VALUE || results < Integer.MIN_VALUE) {
            return 0;
        }

        if (x < 0) {
            results = -results;
        }
        return (int) results;

    }

}

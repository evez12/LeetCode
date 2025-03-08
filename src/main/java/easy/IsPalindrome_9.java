package easy;

public class IsPalindrome_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(120));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x) { // 121
        int tempX = x, reverseX = 0;
        while (x > 0) { // 121, 12, 1
            reverseX = reverseX * 10;// 0,10,120
            reverseX = (reverseX + x % 10); // 1, (10+2) = 12,121
            x = x / 10; // 12,1,0
        }
        return tempX == reverseX;
    }

}

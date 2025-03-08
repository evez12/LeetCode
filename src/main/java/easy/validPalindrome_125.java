package easy;

public class validPalindrome_125 {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String s1 =     "race a car";
        String s2 = " ac ca";
        String s3 = "Was it a car or a cat I saw?";

//        System.out.println(s + ": " + isPalindrome(s));
//        System.out.println(s1 + ": " + isPalindrome(s1));
//        System.out.println(s2 + ": " + isPalindrome(s2));
        System.out.println(s3 + ": " + isPalindrome(s3));
    }

    public static boolean isPalindrome(String s) {
//        int size = s.length();
        int left = 0, right = s.length() - 1;
        while (right >= left) {
            char leftSymbol = s.charAt(left);
            char rightSymbol = s.charAt(right);
            if (Character.isLetterOrDigit(leftSymbol)) { // letter or digit check
                if (Character.isLetterOrDigit(rightSymbol)) {
                    if (Character.toLowerCase(leftSymbol) != Character.toLowerCase(rightSymbol)) {
                        return false;
                    }
                    left++;
                    right--;
                    System.out.println("Both reduced, left: " + left + " right: " + right);
                } else {
                    right--;
                    System.out.println("rightSymbol: " + rightSymbol + ", right: " + right);
                }
            } else {
                left++;
                System.out.println("leftSymbol: " + leftSymbol + ", left: " + left);
            }
        }
        return true;
    }
}

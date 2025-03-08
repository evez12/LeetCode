package easy;

public class RansomNote_383 {
    public static void main(String[] args) {
        String ransomNote1 = "a", magazine1 = "b";
        String ransomNote2 = "aa", magazine2 = "ab";
        String ransomNote3 = "aa", magazine3 = "aab";
        System.out.println("1: " + canConstruct(ransomNote1, magazine1));
        System.out.println("2: " + canConstruct(ransomNote2, magazine2));
        System.out.println("3: " + canConstruct(ransomNote3, magazine3));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] countOfLetters = new int[27]; // 0 ->a, 1->b ....
        for (int i = 0; i < magazine.length(); i++) { //
            int indexOfASCII = magazine.charAt(i);  //a => 97, b=> 98 ....
            countOfLetters[indexOfASCII - 97]++; // count of "a" in magazine = countOfLetters[0]
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int indexOfASCII = ransomNote.charAt(i);
            System.out.println("index: " + indexOfASCII);
            if (countOfLetters[indexOfASCII - 97] == 0) { // exp: indexOfASCII = 97 , reduce a or indexOfASCII = 98 , reduce 7
                return false;
            }
            countOfLetters[indexOfASCII - 97]--;
        }
        return true;
    }
}

package easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";

        System.out.println("chekc1: " + isAnagram1(s, t));
        System.out.println("chekc1: " + isAnagram1("anagram", "nagaram"));
        System.out.println("chekc1: " + isAnagram1("rat", "car"));
    }

    /**
     * @param s
     * @param t
     * @return
     */

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        // if their sizes are different
        if (s.length() != t.length()) return false;

        // if s and t is anagram, then their different character count equal.
        // Exp: if count of "a" in s equal 5, then count of "a" in t must equal is 5
        // I count each character and to increase suitable index in array
        // "a"'s index equal is 0, b equal is 1 , ....
        // s and t consist of lowercase English letters. and count of different character is 27
        int[] counter = new int[27];
        for (int i = 0; i < s.length(); i++) { // already s.length() = t.length()
            int indexOfASCIIForS = s.charAt(i); // a=>97,b=>98
            int indexOfASCIIForT = t.charAt(i); // a=>97,b=>98
            // count of "a" in s = countOfChar[0], b=countOfChar[1]   ...;    a=0,b=1,c=2 ...
            counter[indexOfASCIIForS - 'a']++; // 'b' - 'a' = 1
            counter[indexOfASCIIForT - 'a']--; // 'a' - 'a' = 0
        }
        //if s and t is anagram, then all countOfChar's value equal must zero;
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


}

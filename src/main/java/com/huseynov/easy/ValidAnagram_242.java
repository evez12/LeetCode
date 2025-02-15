package com.huseynov.easy;

import java.util.HashMap;

public class ValidAnagram_242 {
    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";

        System.out.println("chekc1: " + isAnagram2(s, t));
    }
    public static boolean isAnagram1(String s, String t) {
        // if their sizes are different
        if (s.length() != t.length()) return false;
        // value equals count of char (exp: (a,3),(n,1))
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // if already has char then its value increase 1
            // for "s" string
            if (sHashMap.containsKey(s.charAt(i))) {
                Integer value = sHashMap.get(s.charAt(i));
                value++;
                sHashMap.put(s.charAt(i), value);
            } else { // if add first time then its value set 1 (value equals count of char)
                sHashMap.put(s.charAt(i), 1);
            }

            // do same process for "t" string
            if (tHashMap.containsKey(t.charAt(i))) {
                Integer value = tHashMap.get(t.charAt(i));
                value++;
                tHashMap.put(t.charAt(i), value);
            } else {
                tHashMap.put(t.charAt(i), 1);
            }
        }

//        System.out.println(sHashMap);
//        System.out.println(tHashMap);
        return sHashMap.equals(tHashMap);
    }

    public static boolean isAnagram2(String s, String t) {
        // if their sizes are different
        if (s.length() != t.length()) return false;

        // if s and t is anagram, then their different character count equal.
        // Exp: if count of "a" in s equal 5, then count of "a" in t must equal is 5
        // I count each character and to increase suitable index in array
        // "a"'s index equal is 0, b equal is 1 , ....
        // s and t consist of lowercase English letters. and count of different character is 27
        int[] countOfChar = new int[27];
        for (int i = 0; i < s.length(); i++) { // already s.length() = t.length()
            int indexOfASCIIForS = s.charAt(i); // a=>97,b=>98
            int indexOfASCIIForT = t.charAt(i); // a=>97,b=>98
            // count of "a" in s = countOfChar[0], b=countOfChar[1]   ...;    a=0,b=1 ...
            countOfChar[indexOfASCIIForS - 97]++;
            countOfChar[indexOfASCIIForT - 97]--;
        }
        //if s and t is anagram, then all countOfChar's value equal must zero;
        for (int count : countOfChar) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


}

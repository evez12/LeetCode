package com.huseynov.easy;

import java.util.HashMap;

public class ValidAnagram_242 {
    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";

        System.out.println("chekc1: " + isAnagram1(s, t));
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

}

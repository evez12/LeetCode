package com.huseynov.easy;

import java.util.HashMap;

public class IsomorphicStrings_205 {
    public static void main(String[] args) {
        // a=1,b=2,c=3,d=4,e=5,f=6,g=7,h=8
        System.out.println(isIsomorphic("egg", "add")); // diff = 4
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba")); //
    }

   /**
     * Determines if two strings are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * @param s the first string
     * @param t the second string
     * @return true if the strings are isomorphic, false otherwise
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapForS = new HashMap<>();
        HashMap<Character, Character> mapForT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mapForS.containsKey(charS)) {
                if(mapForS.get(charS) != charT) return false;
            } else if (mapForT.containsKey(charT)) {
                if(mapForT.get(charT) != charS) return false;
            } else {
                mapForS.put(charS, charT);
                mapForT.put(charT, charS);
            }
        }
        return true;
    }
}

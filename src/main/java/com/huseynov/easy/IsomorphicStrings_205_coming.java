package com.huseynov.easy;

import java.util.HashMap;

public class IsomorphicStrings_205_coming {
    public static void main(String[] args) {
        // a=1,b=2,c=3,d=4,e=5,f=6,g=7,h=8
        System.out.println(isIsomorphic("egg", "add")); // diff = 4
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba")); //
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapForS = new HashMap<>();
        HashMap<Character, Character> mapForT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i); // o
            char charT = t.charAt(i); // r
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

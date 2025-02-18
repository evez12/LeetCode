package com.huseynov.easy;

public class FindIndexFirstOccurrenceString_28 {


    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        int count = 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(j + i) == needle.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == needle.length()) {
                return i;
            }
            count = 0;
        }
        return -1;
    }

}

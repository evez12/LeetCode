package com.huseynov.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInString_151 {

    public static void main(String[] args) {
        System.out.println(reverseWords2("  hello world  "));

        System.out.println(reverseWords2("and good day"));

        System.out.println(reverseWords2("a good day"));

        System.out.println(reverseWords2("a good   example"));
    }

    /**
     * @param s
     * Time Complexity:𝑂(𝑛)
     * Space Complexity:𝑂(𝑛)
     * n = s.length
     * @return String
     */
    public static String reverseWords2(String s) {
        String[] array = s.split(" ");
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            String temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }

        return Arrays.stream(array)
                .filter(w -> !w.trim().isEmpty())
                .collect(Collectors.joining(" "));
    }
}

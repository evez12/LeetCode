package com.huseynov.medium;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        String[] strs2 = {"a"};
        System.out.println(groupAnagrams(strs2));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String originalWord = strs[i];
            char[] charArray = originalWord.toCharArray(); // for quickly sort
            Arrays.sort(charArray); // sorted process
            String sortedWord = new String(charArray); //for quickly convert to string

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(originalWord);

            } else {
                List<String> list = new ArrayList<>();
                list.add(originalWord);
                map.put(sortedWord, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> values = entry.getValue();
            result.add(values);
        }

        return result;

    }
}

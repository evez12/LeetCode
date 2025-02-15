package com.huseynov.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs1));
//        System.out.println(groupAnagrams1(strs1));
        String[] strs2 = {"a"};
//        System.out.println(groupAnagrams1(strs2));
        System.out.println(groupAnagrams2(strs2));
    }

    /**
     * Description:
     * This function groups anagrams from a given array of strings using a frequency-based approach.
     * Instead of sorting characters, it creates a unique signature for each word based on character counts.
     * <p>
     * Implementation Details:
     * 1. A `HashMap<String, List<String>>` is used to store groups of anagrams.
     * 2. For each word, an integer array of size 26 (`countOfEachChar`) is used to count occurrences of each letter ('a' to 'z').
     * 3. The character frequency array is converted into a string (`convertedWord`) using `Arrays.toString(countOfEachChar)`, ensuring a unique key for anagram groups.
     * 4. The `computeIfAbsent` method is used to efficiently add words to the corresponding group in the map.
     * 5. The values of the map (grouped anagrams) are returned as a list.
     * <p>
     * Advantages:
     * - More efficient than sorting-based approaches for longer strings since it uses constant-time array operations instead of sorting (O(m * n) instead of O(n log n)).
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            int[] countOfEachChar = new int[26];
            for (char c : word.toCharArray()) {
                countOfEachChar[c - 'a']++;
            }
            String convertedWord = Arrays.toString(countOfEachChar);
            map.computeIfAbsent(convertedWord, lis -> new ArrayList<>()).add(word);
        }
        return map.values().stream().toList();
    }

    /**
     * Groups an array of strings into anagrams.
     *
     * @param strs the array of strings to be grouped
     * @return a list of lists of anagrams
     * @implNote The time complexity is O(m * n * log(n)), where m is the length of strs and n is the length of each word.
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String originalWord : strs) {
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
        return map.values().stream().toList();

    }
}

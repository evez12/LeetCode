package easy;

import java.util.HashMap;

public class WordPattern_290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> mapCharToWord = new HashMap<>();
        HashMap<String, Character> mapWordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (mapCharToWord.containsKey(c) && !mapCharToWord.get(c).equals(word)) return false;
            if (mapWordToChar.containsKey(word) && !mapWordToChar.get(word).equals(c)) return false;

            mapCharToWord.put(c, word);
            mapWordToChar.put(word, c);
        }

        return true;
    }
}

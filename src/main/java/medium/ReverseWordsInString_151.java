package medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInString_151 {

    public static void main(String[] args) {
        System.out.println(reverseWords2("  hello world  "));

//        System.out.println(reverseWords2("and good day"));
//
//        System.out.println(reverseWords2("a good day"));
//
//        System.out.println(reverseWords2("a good   example"));
    }


    // Space complexity O(1)
    public static String reverseWords1(String s) {
        int size = s.length();
        int end = size - 1;
        StringBuilder result = new StringBuilder();

        while (end >= 0) {
            // Boşluqları keçirik
            while (end >= 0 && s.charAt(end) == ' ') end--;
            if (end < 0) break; // Əgər bitdisə, çıxırıq

            // Sözün başlanğıcını tapırıq
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') start--;

            // Sözü əlavə edirik
            if (result.length() > 0) result.append(' '); // Araya tək boşluq qoyuruq
            result.append(s.substring(start + 1, end + 1));

            // Növbəti sözə keçirik
            end = start - 1;
        }

        return result.toString();
    }

    /**
     * @param s Time Complexity:𝑂(𝑛)
     *          Space Complexity:𝑂(𝑛)
     *          n = s.length
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

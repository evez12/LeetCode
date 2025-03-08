package easy;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        System.out.println(longestCommonPrefix(strs));
//
//        String[] strs2 = {"dog", "racecar", "car"};
//        System.out.println(longestCommonPrefix(strs2));

//        String[] strs3 = {"ab", "a"};
//        System.out.println(longestCommonPrefix(strs3));

        String[] strs4 = {"abab","aba",""};
        System.out.println(longestCommonPrefix2(strs4));
    }

    public static String longestCommonPrefix2(String[] strs) {
        String prefix = "";
        int size = strs[0].length();
        char ch;
        for (int j = 0; j < size; j++) {
            ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {

                // set min size
                if (size > strs[i].length()) {
                    size = strs[i].length();
                }

                if(strs[i].length() == 0){
                    return prefix;
                }

                if (ch != strs[i].charAt(j)) {
                    return prefix;
                }
            }
            prefix += "" + ch;
        }
        return prefix;
    }
    public static String longestCommonPrefix1(String[] strs) {
        String prefix = "";
        int size = strs[0].length();
        char ch;
        for (int j = 0; j < size; j++) {
            ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {

                if(strs[i].length() == 0 || ch != strs[i].charAt(j)){
                    return prefix;
                }

                // set min size
                if (size > strs[i].length()) {
                    size = strs[i].length();
                }


            }
            prefix += "" + ch;
        }
        return prefix;
    }
}

package easy;

public class IsSubsequences_392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        String s1 = "axc", t1 = "ahbgdc";
        System.out.println(isSubsequences(s, t));
        System.out.println(isSubsequences(s1, t1));
        String s2 = "", t2 = "ahbgdc";
        System.out.println(isSubsequences(s2, t2));
        String s3 = "b", t3 = "ahbgdc";
        System.out.println(isSubsequences(s3, t3));
    }

    public static boolean isSubsequences(String s, String t) {
        int indexS = 0;
        if(s.length() == 0) return true;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()){
                    return true;
                }
            }
        }
        return s.length() == indexS;
    }
}

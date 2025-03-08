package easy;

public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); //4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(lengthOfLastWord("Helloww    ")); // 7
        System.out.println(lengthOfLastWord("      Hewllo    ")); // 6
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        boolean isStart = false;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                isStart = true;
                count++;
            }

            if (s.charAt(i) == ' ' && isStart) {
                break;
            }

        }
        return count;
    }
}

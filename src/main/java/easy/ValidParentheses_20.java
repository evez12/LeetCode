package easy;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s1 = "(())(())()";
        String s2 = "(())(())())"; // (()) (()) () )
        String s3 = "((()))";
        String s4 = "(())";
        String s5 = "()";
        String s6 = "()[]{}";
        String s7 = "([])";
        String s8 = "(])";
        System.out.println(s1 + ": " + isValid(s1) + "\n");
        System.out.println(s2 + ": " + isValid(s2));
        System.out.println(s3 + ": " + isValid(s3));
        System.out.println(s4 + ": " + isValid(s4));
        System.out.println(s5 + ": " + isValid(s5));
        System.out.println(s6 + ": " + isValid(s6));
        System.out.println(s7 + ": " + isValid(s7));
        System.out.println(s8 + ": " + isValid(s8));

    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) { //  s= "(())(()) () )"
//            System.out.println("Started: " + characterStack);

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') { // (
                    characterStack.push(s.charAt(i));
                } else if (!characterStack.isEmpty()) { // ')'
                    if (characterStack.peek() == '(') {
                        characterStack.pop();
                    }
                    else return false;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']' || s.charAt(i) == '[') {
                if (s.charAt(i) == '[') { // (
                    characterStack.push(s.charAt(i));
                } else if (!characterStack.isEmpty()) { // ']'
                    if (characterStack.peek() == '[') {
                        characterStack.pop();
                    }
                    else return false;
                } else {
                    return false;
                }
            } else {
                if (s.charAt(i) == '{') { // (
                    characterStack.push(s.charAt(i));
                } else if (!characterStack.isEmpty()) { // ')'
                    if (characterStack.peek() == '{') {
                        characterStack.pop();
                    }
                    else return false;
                } else {
                    return false;
                }
            }
        }
        System.out.println("\nLast stack: " + characterStack);
        return characterStack.isEmpty();
    }
}

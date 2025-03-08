package easy;

public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));

        System.out.println(addBinary("11", "11"));

        System.out.println(addBinary("111", ""));

        System.out.println(addBinary("10", "1"));

        System.out.println(addBinary("10", "10"));

        System.out.println(addBinary("1010", "1011"));

        System.out.println(addBinary("1", "1011"));
        System.out.println(addBinary("1011", "1"));

        System.out.println(addBinary("1011", "10"));

        System.out.println(addBinary("101", "1011"));

    }

    public static String addBinary(String a, String b) {
        int size1 = a.length(), size2 = b.length();

        if (size1 == 0) return b;
        if (size2 == 0) return a;

        StringBuilder answer = new StringBuilder();
        int indexA = size1 - 1, indexB = size2 - 1, carry = 0;

        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            int digit1 = (indexA >= 0) ? a.charAt(indexA--) - '0' : 0;
            int digit2 = (indexB >= 0) ? b.charAt(indexB--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            answer.append(sum % 2);
            carry = sum / 2;
        }

        return answer.reverse().toString();



//        int size1 = a.length(), size2 = b.length();
//        if (size1 == 0) return b;
//        if (size2 == 0) return a;
//
//
//        String answer = "";
//        int indexA = size1 - 1;
//        int indexB = size2 - 1;
//        int quatient = 0;
//        int zeroCode = '0';
//        while (indexA >= 0 || indexB >= 0) {
//            if (indexA >= 0 && indexB >= 0) {
//                int digit1 = a.charAt(indexA--) - zeroCode;
//                int digit2 = b.charAt(indexB--) - zeroCode;
//                quatient = digit1 + digit2 + quatient;
//                if (quatient > 1) {
//                    answer = (quatient % 2) + answer;
//                    quatient = quatient / 2;
//                } else {
//                    answer = quatient + answer;
//                    quatient = 0;
//                }
//            } else if (indexA >= 0) {
//                int digit1 = a.charAt(indexA--) - zeroCode;
//                quatient = digit1 + quatient;
//                if (quatient > 1) {
//                    answer = (quatient % 2) + answer;
//                    quatient = quatient / 2;
//                } else {
//                    answer = quatient + answer;
//                    quatient = 0;
//                }
//            } else {
//                int digit2 = b.charAt(indexB--) - zeroCode;
//                quatient = digit2 + quatient;
//                if (quatient > 1) {
//                    answer = (quatient % 2) + answer;
//                    quatient = quatient / 2;
//                } else {
//                    answer = quatient + answer;
//                    quatient = 0;
//                }
//            }
//        }
//
//        if (quatient > 0) {
//            answer = quatient + answer;
//        }
//
//        return answer;
    }
}

package easy;

public class PlusOne_66 {
    public static void main(String[] args) {
        test();

    }

    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int lastIndex = size - 1; //
        int newLastElement = digits[lastIndex] + 1;

        if (newLastElement <= 9) { // exp: {1,2,3}; {4,8}
            digits[lastIndex] = newLastElement;
        } else { // exp: {1,2,9}. {9,9,9}
            int remainder = 0, i = size - 1;
            int checkerValue = newLastElement + remainder;
            while (checkerValue > 9) {
                remainder = checkerValue / 10;
                newLastElement = checkerValue % 10;
                digits[i] = newLastElement;
                if (i == 0) { // {9,9}, {9} ....
                    int[] newArray = new int[digits.length + 1];
                    System.arraycopy(digits, 0, newArray, 1, digits.length);
                    newArray[0] = 1; // {9} => {1,0}; {9,9,9} => {1,0,0,0}
                    return newArray;
                }
                checkerValue = digits[i - 1] + remainder;
                i--;
            }
            digits[i] = checkerValue;
        }
        return digits;
    }

    private static void test() {
        int[] digits1 = {1, 2, 3}, digits2 = {4, 3, 2, 1}, digits3 = {9, 9, 9}, digits4 = {2, 9, 9};

        System.out.println('\n');
        for (int i : plusOne(digits1)) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
        for (int i : plusOne(digits2)) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
        for (int i : plusOne(digits3)) {
            System.out.print(i + " ");
        }

        System.out.println('\n');
        for (int i : plusOne(digits4)) {
            System.out.print(i + " ");
        }
    }
}

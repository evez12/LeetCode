package recursion;

public class Sum {
    public static void main(String[] args) {
        System.out.println(recursionSum(5));
        System.out.println(recursionSum(1));
        System.out.println(recursionSum(0));
        System.out.println(recursionSum(6));
        System.out.println(recursionSum(10));

    }

    public static int recursionSum(int n) {
        if (n == 0) return 0;

        return n + recursionSum((n - 1));
    }
}

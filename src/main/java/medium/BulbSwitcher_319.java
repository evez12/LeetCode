package medium;

public class BulbSwitcher_319 {
    public static void main(String[] args) {

        for (int i = 0; i < 26; i++) {
            System.out.println("Result for " + i + ": " + bulbSwitch(i));
        }

    }

    public static int bulbSwitch(int n) {
        return  (int) Math.sqrt(n);
    }
}

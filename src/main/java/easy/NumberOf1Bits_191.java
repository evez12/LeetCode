package easy;

public class NumberOf1Bits_191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {
        int countOfOne=0;
        while(n>0){
            if(n%2==1){
                countOfOne++;
            }
            n = n / 2;
        }
        return countOfOne;
    }
}

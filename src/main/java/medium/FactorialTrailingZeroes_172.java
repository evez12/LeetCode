package medium;

//Given an integer n, return the number of trailing zeroes in n!.
//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
public class FactorialTrailingZeroes_172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(30));
        System.out.println(trailingZeroes(50));
    }

    // Problem:
    //Given an integer n, return the number of trailing zeroes in n!.
    //Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
    //Input: n = 3, Output: 0, Explanation: 3! = 6, no trailing zero.
//    Input: n = 5, Output: 1, Explanation: 5! = 120, one trailing zero.
    //Approach:
    // iki ededin hasilinin sonun'da "0" olmaqin isteyirikse, onda gerek hemin ededlerin bolenlerinin daxilinde 2 ve 5 olsun.
//    meselen: x = 15, y = 6 => x*y=90; x = 5 * 3, y = 3 * 2 ; x = 10 , y = 7 => x*y=70; x = 2 * 5, y =7; (2 ve 5 mutleq olmalidir)
    // (2,5) cutlerin sayi qeder edenin sonunda "0" var.
    // tebii ki eded'de 2'lerin sayi 5'lerde cox olur.
    // burdanda aydin olurki n'de "0" sayi 5'lerin sayi qederdir.
    // meselen 30'da 1 dene "0" demeli bolenlerinde 1 dene 5 var (30 = 2*3*5)
    // n!'da 5'lerin sayi evvelce n/5 ve 5'in quvvetlerin nezere almaq lazimdir
    // n = 30 ; 30!  5'lerin sayi (30/5) + 1 ; 1 niye cunki 25'de 2 bes var amma biz onu 1 debe olaraq gotururuk;
    public static int trailingZeroes(int n) {
        int count = 0;
        double divided = 0.0;
        int power = 1;
        int result = n / 5;
        while (result > 0) {
            count += result;
            power++;
            divided = n / Math.pow(5, power);
            result = (int) divided;
        }
        return count;
    }
}

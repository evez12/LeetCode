package easy;

public class Sqrt_x_69 {
    public static void main(String[] args) {
        System.out.print("Input 2147395599:");
        System.out.println(mySqrt(2147395599));

                System.out.print("Input 100: ");
        System.out.println(mySqrt(100));
        System.out.print("Input 10: ");
        System.out.println(mySqrt(10));
        System.out.print("Input 8: ");
        System.out.println(mySqrt(8));
        System.out.print("Input 4: ");
        System.out.println(mySqrt(4));
        System.out.print("Input 2: ");
        System.out.println(mySqrt(2));
        System.out.print("Input 1: ");
        System.out.println(mySqrt(1));
        System.out.print("Input 0: ");
        System.out.println(mySqrt(0));
        System.out.print("Input 11: ");
        System.out.println(mySqrt(11));
        System.out.print("Input 9: ");
        System.out.println(mySqrt(9));

    }

    //                         2147395599
    //Integer.MAX_VALUE==> 2147483647
//     1073697800
//      536848899
    public static int mySqrt(int x) {
        int answer = 0, temp = 0;
        int left = 0, right = x / 2;

        if (x == 1 || x == 0) return x;

        while (left < right) {
            temp = (left + (right - left) / 2) + 1;
//            System.out.println("temp: " + temp);
// temp * temp <= x  bu int kecir ona gore t <= x/temp yazsaq yaxsi olar (temp != 0) olduqun bilirik
            if ((temp + 1) > x / (temp + 1) && temp <= x / temp) {
                answer = temp;
//                System.out.println("answer: " + answer);
//                break;
                return answer;
            } else if (temp < x / temp) {
                left = temp + 1;
//                System.out.println("left: " + left);
            } else {
                right = temp - 1;
//                System.out.println("right: " + right);
            }
        }
        return right;
    }
}

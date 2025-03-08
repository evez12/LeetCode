public class BestSightseeingPair_1014 {

    public static void main(String[] args) {

        int[] values = {8, 1, 5, 2, 6};
        int result1 = maxScoreSightseeingPair(values);
        System.out.println("Result1: " + result1);
        System.out.println();

        int[] values2 = {1, 2};
        int result2 = maxScoreSightseeingPair(values2);
        System.out.println("Result2: " + result2);
        System.out.println();

        int[] values3 = {1, 3, 5};
        int result3 = maxScoreSightseeingPair(values3);
        System.out.println("Result2: " + result3);
        System.out.println();

        int[] values4 = {1, 2, 2};
        int result4 = maxScoreSightseeingPair(values4);
        System.out.println("Result2: " + result4);
        System.out.println();


    }

    public static int maxScoreSightseeingPair(int[] values) {
        int diffJ = 0, sumI = 0, sum = 0; // sumI = values[0] + 0
        int j = 1;
        int i = 0;

        for (int k = 1; k < values.length; k++) {

            if( (values[k] - k) >= diffJ){
                diffJ = values[k] -k;
                j++;
            }

            sumI = values[i] + i;
            int currentSum = sum + diffJ;

            if( i < j && currentSum > sum){
                sum = sumI + diffJ;
                i++;
            }


        }

        System.out.println("SumI: " + sumI);
        System.out.println("SumJ: " + diffJ);
        System.out.println("ResultJ: " + j);
        System.out.println("ResultI: " + i);
        return sum;
    }
}



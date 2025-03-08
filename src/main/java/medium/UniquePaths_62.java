package medium;

public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
        System.out.println(uniquePaths(3, 7 ));
    }


    //
    public static int uniquePaths(int n, int m) {
//            int result = 0;
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            array[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            array[n - 1][j] = 1;
        }

        for (int i = n - 2; i >= 0; i--) { // i =2
            for (int j = 1; j < m; j++) { // i =2, j =1 => array[2][1]
                array[i][j] = array[i][j - 1] + array[i + 1][j];
//                if (i == 0 && j == m - 1) {
//                    result = array[i][j - 1] + array[i + 1][j];
//                }
            }
        }
        return array[0][m - 1];
    }
}

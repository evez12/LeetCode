package com.huseynov.medium;

public class SearchA2DMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 3));
//        System.out.println(matrix.length);

        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix2, 13));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (right >= left) {
// 0, 1, 2, 3,  4, 5,   6,  7,  8, 9,  10, 11   index
// 1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60   elements
            int index = left + (right - left) / 2;
            int i = index / n; // set row
            int j = index % n; // set col
            int element = matrix[i][j];  // matrix's "index"th element

            if (element == target) {
                return true;
            }
            if (target > element) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return false;
    }
}

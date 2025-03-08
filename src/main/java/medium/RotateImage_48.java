package medium;

public class RotateImage_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] newMatrix = new int[size][size];
        for (int i = 0,k=0; i < size; i++) {
            for (int j = size - 1,l=0; j >= 0; j--) {
                newMatrix[k][l++] = matrix[j][i];
            }
            k++;

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}

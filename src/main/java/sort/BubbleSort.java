package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        int size = array.length;

        for (int i = 0; i < size; i++) { // 2, 3, 1, 5, 0, 1, 1
            for (int j = 0; j < size - 1 - i; j++) { // 2, 3, 1, 5, 0, 1, 1
                if (array[j + 1] < array[j]) { //
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int k : array) {
            System.out.print(k + " ");
        }
    }


}



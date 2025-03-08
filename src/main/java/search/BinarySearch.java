package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 0, 1, 1};
        // test case
        binarySearch(array, 10);
        binarySearch(array, 1);
        binarySearch(array, 0);
        binarySearch(array, 2);
        binarySearch(array, 5);

    }

    /**
     * Performs a binary search on a sorted array to find the target element.
     *
     * @param array  the sorted array to search
     * @param target the element to search for
     */
    public static void binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid = 0;
        boolean isFound = false;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (array[mid] == target) {
                isFound = true;
                break;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        if (isFound) {
            System.out.println("Element found: " + target + ", index: " + mid);

        } else System.out.println("Not Found: " + target);
    }
}

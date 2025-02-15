package com.huseynov.medium;

import java.util.Arrays;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals1 = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals1)));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge(intervals2)));

        int[][] intervals3 = {{2, 6}, {1, 3}, {6, 10}, {10, 18}};
        System.out.println(Arrays.deepToString(merge(intervals3)));

        int[][] intervals4 = {{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(merge(intervals4)));

        int[][] intervals5 = {{1, 4}, {5, 6}};
        System.out.println(Arrays.deepToString(merge(intervals5)));

    }

    public static int[][] merge(int[][] intervals) {

        int size = intervals.length;
        if (size == 1) return intervals;  // edge case

//        [[1, 3], [2, 6], [8, 10], [15, 18]]
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] newIntervals = new int[size][2];
        int newSize = 0;
        boolean checker = true;
        for (int i = 1; i < size; i++) {
            int start = intervals[i - 1][0], end = intervals[i - 1][1];
            while (end >= intervals[i][0]) {
                if (end < intervals[i][1]) {
                    end = intervals[i][1];
                }
                i++;
                if (i == size) {
                    checker = false;
                    break;
                }
            }
            newIntervals[newSize][0] = start;
            newIntervals[newSize++][1] = end;
        }
        if (checker) {
            newIntervals[newSize][0] = intervals[size - 1][0];
            newIntervals[newSize++][1] = intervals[size - 1][1];
        }
        int[][] answer = new int[newSize][2];
        for (int i = 0; i < newSize; i++) {
            answer[i][0] = newIntervals[i][0];
            answer[i][1] = newIntervals[i][1];

        }
        return answer;
    }

}

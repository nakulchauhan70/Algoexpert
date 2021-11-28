package com.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(intervals)));
    }

    //O(nlogn) time | O(n) space
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> mergedOverlappedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        mergedOverlappedIntervals.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];


            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedOverlappedIntervals.add(currentInterval);
            }
        }

        return mergedOverlappedIntervals.toArray(new int[mergedOverlappedIntervals.size()][]);
    }
}

/*
Test Cases
Test Case 1
    {
    "intervals": [
    [1, 2],
    [3, 5],
    [4, 7],
    [6, 8],
    [9, 10]
    ]
    }
    Test Case 2
    {
    "intervals": [
    [1, 3],
    [2, 8],
    [9, 10]
    ]
    }
    Test Case 3
    {
    "intervals": [
    [1, 10],
    [10, 20],
    [20, 30],
    [30, 40],
    [40, 50],
    [50, 60],
    [60, 70],
    [70, 80],
    [80, 90],
    [90, 100]
    ]
    }
    Test Case 4
    {
    "intervals": [
    [1, 10],
    [11, 20],
    [21, 30],
    [31, 40],
    [41, 50],
    [51, 60],
    [61, 70],
    [71, 80],
    [81, 90],
    [91, 100]
    ]
    }
    Test Case 5
    {
    "intervals": [
    [100, 105],
    [1, 104]
    ]
    }
    Test Case 6
    {
    "intervals": [
    [89, 90],
    [-10, 20],
    [-50, 0],
    [70, 90],
    [90, 91],
    [90, 95]
    ]
    }
    Test Case 7
    {
    "intervals": [
    [-5, -4],
    [-4, -3],
    [-3, -2],
    [-2, -1],
    [-1, 0]
    ]
    }
    Test Case 8
    {
    "intervals": [
    [43, 49],
    [9, 12],
    [12, 54],
    [45, 90],
    [91, 93]
    ]
    }
    Test Case 9
    {
    "intervals": [
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0]
    ]
    }
    Test Case 10
    {
    "intervals": [
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 0],
    [0, 1]
    ]
    }
    Test Case 11
    {
    "intervals": [
    [1, 22],
    [-20, 30]
    ]
    }
    Test Case 12
    {
    "intervals": [
    [20, 21],
    [22, 23],
    [0, 1],
    [3, 4],
    [23, 24],
    [25, 27],
    [5, 6],
    [7, 19]
    ]
    }
    Test Case 13
    {
    "intervals": [
    [2, 3],
    [4, 5],
    [6, 7],
    [8, 9],
    [1, 10]
    ]
    }
*/

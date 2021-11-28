package com.problems.array;

import java.util.Arrays;

public class SubarraySort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }

    //O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }

        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int subarrayLeftIndex = 0;

        while (minOutOfOrder >= array[subarrayLeftIndex]) {
            subarrayLeftIndex++;
        }

        int subarrayRightIndex = array.length - 1;

        while (maxOutOfOrder <= array[subarrayRightIndex]) {
            subarrayRightIndex--;
        }

        return new int[]{subarrayLeftIndex, subarrayRightIndex};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }

        if (i == array.length - 1) {
            return num < array[i - 1];
        }

        return num > array[i + 1] || num < array[i - 1];
    }
}


/*
Test Cases

Test Case 1
    {
    "array": [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
    }
    Test Case 2
    {
    "array": [1, 2]
    }
    Test Case 3
    {
    "array": [2, 1]
    }
    Test Case 4
    {
    "array": [1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19]
    }
    Test Case 5
    {
    "array": [1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19]
    }
    Test Case 6
    {
    "array": [1, 2, 8, 4, 5]
    }
    Test Case 7
    {
    "array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]
    }
    Test Case 8
    {
    "array": [4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]
    }
    Test Case 9
    {
    "array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57]
    }
    Test Case 10
    {
    "array": [-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7]
    }
    Test Case 11
    {
    "array": [1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11]
    }
    Test Case 12
    {
    "array": [1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]
    }
    Test Case 13
    {
    "array": [1, 2, 3, 4, 5, 6, 18, 21, 22, 7, 14, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 4, 14, 11, 6, 33, 35, 41, 55]
    }
    Test Case 14
    {
    "array": [1, 2, 20, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
    }
    Test Case 15
    {
    "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2]
    }
    Test Case 16
    {
    "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
    }
    Test Case 17
    {
    "array": [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
    }
*/

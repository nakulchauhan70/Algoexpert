package com.problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})));
//        System.out.println(Arrays.toString(largestRange(new int[]{1, 2})));
        System.out.println(Arrays.toString(largestRange(new int[]{1})));
    }

    //Approach 1 - Sort array(O(nlogn)) and then keep on checking current element - 1 == prev element and maintain length (O(n)) => O(nlogn) time | O(1) space
    //Approach 2
    //O(n) time | O(n) space
    public static int[] largestRange(int[] array) {
        int[] largestRange = new int[]{1, 1};
        Map<Integer, Boolean> map = new HashMap<>();
        int start;
        int end;
        for (int i : array) {
            map.put(i, true);
        }

        for (int i : array) {
            if (map.get(i)) {
                map.put(i, false);

                start = traceMapBackAndForth(map, i, -1);
                end = traceMapBackAndForth(map, i, 1);

                if ((end - start) > (largestRange[1] - largestRange[0])) {
                    largestRange[0] = start;
                    largestRange[1] = end;
                }
            }
        }

        return largestRange;
    }

    private static int traceMapBackAndForth(Map<Integer, Boolean> map, int i, int step) {
        int bound = i;
        int element = i + step;

        Boolean value = map.get(element);

        while (value != null && value) {
            map.put(element, false);
            bound = element;
            element = element + step;
            value = map.get(element);
        }

        return bound;
    }
}

/*

Test Cases
Test Case 1
    {
    "array": [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
    }
    Test Case 2
    {
    "array": [1]
    }
    Test Case 3
    {
    "array": [1, 2]
    }
    Test Case 4
    {
    "array": [4, 2, 1, 3]
    }
    Test Case 5
    {
    "array": [4, 2, 1, 3, 6]
    }
    Test Case 6
    {
    "array": [8, 4, 2, 10, 3, 6, 7, 9, 1]
    }
    Test Case 7
    {
    "array": [19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14]
    }
    Test Case 8
    {
    "array": [0, 9, 19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14]
    }
    Test Case 9
    {
    "array": [0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6, 13, 14, -2]
    }
    Test Case 10
    {
    "array": [-7, -7, -7, -7, 8, -8, 0, 9, 19, -1, -3, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, -6, 8, 7, 6, 15, 12, 12, -5, 2, 1, 6, 13, 14, -4, -2]
    }
    Test Case 11
    {
    "array": [1, 1, 1, 3, 4]
    }
    Test Case 12
    {
    "array": [-1, 0, 1]
    }
    Test Case 13
    {
    "array": [10, 0, 1]
    }
*/
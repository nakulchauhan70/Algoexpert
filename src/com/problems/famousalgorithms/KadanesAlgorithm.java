package com.problems.famousalgorithms;

import java.util.Arrays;

//AKA - Max sub array sum problem
public class KadanesAlgorithm {
    public static void main(String[] args) {
//        System.out.println(kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
//        System.out.println(kadanesAlgorithm(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10}));
        System.out.println(Arrays.toString(kadanesAlgorithmToGetSubArray(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4})));
    }

    //O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + array[i], array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    //1,2,3,45
    public static int[] kadanesAlgorithmToGetSubArray(int[] array) {
        int start = 0;
        int end = 0;
        int maxSoFar = array[0];
        int maxEndingHere = array[0];

        for (int i = 1; i < array.length; i++) {
            if ((array[i] > array[i] + maxEndingHere)) {
                start = i;
                maxEndingHere = array[i];
            } else {
                maxEndingHere += array[i];
            }

            if (maxSoFar < maxEndingHere) {
                end = i;
                maxSoFar = maxEndingHere;
            }
        }

        return Arrays.copyOfRange(array, start, end);
    }
}

//Test Cases
/*
Test Case 1
{
"array": [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
}
Test Case 2
{
"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}
Test Case 3
{
"array": [-1, -2, -3, -4, -5, -6, -7, -8, -9, -10]
}
Test Case 4
{
"array": [-10, -2, -9, -4, -8, -6, -7, -1, -3, -5]
}
Test Case 5
{
"array": [1, 2, 3, 4, 5, 6, -20, 7, 8, 9, 10]
}
Test Case 6
{
"array": [1, 2, 3, 4, 5, 6, -22, 7, 8, 9, 10]
}
Test Case 7
{
"array": [1, 2, -4, 3, 5, -9, 8, 1, 2]
}
Test Case 8
{
"array": [3, 4, -6, 7, 8]
}
Test Case 9
{
"array": [3, 4, -6, 7, 8, -18, 100]
}
Test Case 10
{
"array": [3, 4, -6, 7, 8, -15, 100]
}
Test Case 11
{
"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
}
Test Case 12
{
"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 6]
}
Test Case 13
{
"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6]
}
Test Case 14
{
"array": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6, 20, -23, 15, 1, -3, 4]
}
Test Case 15
{
"array": [100, 8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6, 20, -23, 15, 1, -3, 4]
}
Test Case 16
{
"array": [-1000, -1000, 2, 4, -5, -6, -7, -8, -2, -100]
}
Test Case 17
{
"array": [-2, -1]
}
Test Case 18
{
"array": [-2, 1]
}
Test Case 19
{
"array": [-10]
}*/

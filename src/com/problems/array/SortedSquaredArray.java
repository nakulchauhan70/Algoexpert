package com.problems.array;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {

    }

    //Brute force solution - don't use it
    //O(nlogn) time | O(1) space
    public int[] sortedSquaredArray1(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 2);
        }
        Arrays.sort(array); //based on TimSort

        return array;
    }

    //Optimal Solution
    //O(logn) time | O(n) space
    public static int[] sortedSquaredArray2(int[] array) {
        // Write your code here.
        int[] outputArr = new int[array.length];
        int startIndex = 0;
        int endIndex = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int startElement = array[startIndex];
            int endElement = array[endIndex];
            if (Math.abs(startElement) > Math.abs(endElement)) {
                outputArr[i] = startElement * startElement ;
                startIndex++;
            } else {
                outputArr[i] = endElement * endElement;
                endIndex--;
            }
        }
        return outputArr;
    }
}


//Test Cases
/*
Test Case 1
{
"array": [1, 2, 3, 5, 6, 8, 9]
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
"array": [1, 2, 3, 4, 5]
}
Test Case 5
{
"array": [0]
}
Test Case 6
{
"array": [10]
}
Test Case 7
{
"array": [-1]
}
Test Case 8
{
"array": [-2, -1]
}
Test Case 9
{
"array": [-5, -4, -3, -2, -1]
}
Test Case 10
{
"array": [-10]
}
Test Case 11
{
"array": [-10, -5, 0, 5, 10]
}
Test Case 12
{
"array": [-7, -3, 1, 9, 22, 30]
}
Test Case 13
{
"array": [-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20]
}
Test Case 14
{
"array": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
}
Test Case 15
{
"array": [-1, -1, 2, 3, 3, 3, 4]
}
Test Case 16
{
"array": [-3, -2, -1]
}
Test Case 17
{
"array": [-3, -2, -1]
}*/

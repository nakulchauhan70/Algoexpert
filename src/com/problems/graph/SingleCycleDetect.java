package com.problems.graph;

public class SingleCycleDetect {
    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
    }

    //O(n) time | O(1) space
    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIndex = 0;

        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIndex == 0) {
                return false;
            }

            numElementsVisited++;
            currentIndex = getNextIndex(currentIndex, array);
        }
        return currentIndex == 0;
    }

    private static int getNextIndex(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;

        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }
}

/*
Test Cases
Test Case 1
    {
    "array": [2, 3, 1, -4, -4, 2]
    }
    Test Case 2
    {
    "array": [2, 2, -1]
    }
    Test Case 3
    {
    "array": [2, 2, 2]
    }
    Test Case 4
    {
    "array": [1, 1, 1, 1, 1]
    }
    Test Case 5
    {
    "array": [-1, 2, 2]
    }
    Test Case 6
    {
    "array": [0, 1, 1, 1, 1]
    }
    Test Case 7
    {
    "array": [1, 1, 0, 1, 1]
    }
    Test Case 8
    {
    "array": [1, 1, 1, 1, 2]
    }
    Test Case 9
    {
    "array": [3, 5, 6, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]
    }
    Test Case 10
    {
    "array": [3, 5, 5, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]
    }
    Test Case 11
    {
    "array": [1, 2, 3, 4, -2, 3, 7, 8, 1]
    }
    Test Case 12
    {
    "array": [1, 2, 3, 4, -2, 3, 7, 8, -8]
    }
    Test Case 13
    {
    "array": [1, 2, 3, 4, -2, 3, 7, 8, -26]
    }
    Test Case 14
    {
    "array": [10, 11, -6, -23, -2, 3, 88, 908, -26]
    }
    Test Case 15
    {
    "array": [10, 11, -6, -23, -2, 3, 88, 909, -26]
    }
    Test Case 16
    {
    "array": [1, -1, 1, -1]
    }
*/

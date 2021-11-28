package com.problems.searching;

public class QuickSelect {
    public static void main(String[] args) {
        System.out.println(quickselect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3));
    }

    //O(n)- (Average, Best), O(n^2) - (worst) time | O(1) space
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        return quickselectHelper(array, 0, array.length - 1, k - 1);
    }

    private static int quickselectHelper(int[] array, int startIndex, int endIndex, int position) {
        while (true) {
            if (startIndex > endIndex) {
                throw new RuntimeException("Algorithm should never arrive here");
            }

            int pivotIndex = startIndex;
            int leftIndex = startIndex + 1;
            int rightIndex = endIndex;

            while (leftIndex <= rightIndex) {
                if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[leftIndex]) {
                    swap(array, leftIndex, rightIndex);
                } else if (array[leftIndex] <= array[pivotIndex]) {
                    leftIndex++;
                } else if (array[rightIndex] >= array[pivotIndex]) {
                    rightIndex--;
                }
            }

            swap(array, pivotIndex, rightIndex);

            if (rightIndex == position) {
                return array[rightIndex];
            } else if (rightIndex > position) {
                endIndex = rightIndex - 1;
            } else {
                startIndex = rightIndex + 1;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*
Test Cases
Test Case 1
    {
    "array": [8, 5, 2, 9, 7, 6, 3],
    "k": 3
    }
    Test Case 2
    {
    "array": [1],
    "k": 1
    }
    Test Case 3
    {
    "array": [43, 24, 37],
    "k": 1
    }
    Test Case 4
    {
    "array": [43, 24, 37],
    "k": 2
    }
    Test Case 5
    {
    "array": [43, 24, 37],
    "k": 3
    }
    Test Case 6
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 1
    }
    Test Case 7
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 2
    }
    Test Case 8
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 3
    }
    Test Case 9
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 4
    }
    Test Case 10
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 5
    }
    Test Case 11
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 6
    }
    Test Case 12
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 7
    }
    Test Case 13
    {
    "array": [8, 3, 2, 5, 1, 7, 4, 6],
    "k": 8
    }
    Test Case 14
    {
    "array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15],
    "k": 5
    }
    Test Case 15
    {
    "array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15],
    "k": 4
    }
    Test Case 16
    {
    "array": [102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15],
    "k": 9
    }
    Test Case 17
    {
    "array": [1, 3, 71, 123, 124, 156, 814, 1294, 10024, 110000, 985181, 55516151],
    "k": 12
    }
    Test Case 18
    {
    "array": [1, 3, 71, 123, 124, 156, 814, 1294, 10024, 110000, 985181, 55516151],
    "k": 4
    }
*/

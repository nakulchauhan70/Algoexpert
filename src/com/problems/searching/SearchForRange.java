package com.problems.searching;

import java.util.Arrays;

public class SearchForRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchForRange(new int[]{0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73}, 45)));
    }

    public static int[] searchForRange(int[] array, int target) {
        int[] finalRange = new int[]{-1, -1};
        alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
        alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);

        return finalRange;
    }

    //Recursive Approach
    //O(logn) time | O(logn) space
//    private static void alteredBinarySearch(int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
//        if (left > right) {
//            return;
//        }
//
//        int mid = (left + right) / 2;
//
//        if (array[mid] > target) {
//            alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
//        } else if (array[mid] < target) {
//            alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
//        } else {
//            if (goLeft) {
//                if (mid == 0 || array[mid - 1] != target) {
//                    finalRange[0] = mid;
//                } else {
//                    alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
//                }
//            } else {
//                if (mid == array.length - 1 || array[mid + 1] != target) {
//                    finalRange[1] = mid;
//                } else {
//                    alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
//                }
//            }
//        }
//    }

    //Iterative Approach
    //O(logn) time | O(1) space
    private static void alteredBinarySearch(int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                if (goLeft) {
                    if (mid == 0 || array[mid - 1] != target) {
                        finalRange[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        finalRange[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }
}
/*
Test Cases
Test Case 1
    {
    "array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73],
    "target": 45
    }
    Test Case 2
    {
    "array": [5, 7, 7, 8, 8, 10],
    "target": 5
    }
    Test Case 3
    {
    "array": [5, 7, 7, 8, 8, 10],
    "target": 7
    }
    Test Case 4
    {
    "array": [5, 7, 7, 8, 8, 10],
    "target": 8
    }
    Test Case 5
    {
    "array": [5, 7, 7, 8, 8, 10],
    "target": 10
    }
    Test Case 6
    {
    "array": [5, 7, 7, 8, 8, 10],
    "target": 9
    }
    Test Case 7
    {
    "array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73],
    "target": 47
    }
    Test Case 8
    {
    "array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73],
    "target": -1
    }
    Test Case 9
    {
    "array": [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 45, 45, 45],
    "target": 45
    }
*/

package com.problems.searching;

public class ShiftedBinarySearch {
    public static void main(String[] args) {
//        System.out.println(shiftedBinarySearch(new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37}, 33));
        System.out.println(shiftedBinarySearch(new int[]{72, 73, 0, 1, 21, 33, 37, 45, 61, 71}, 72));
    }

    //1,2,3,4,5 => 0,2 3,3 - 0,2 3,4
    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearchHelper(array, 0, array.length - 1, target);
    }

    //O(log(n)) time | O(logn) space - like binary search
//    private static int shiftedBinarySearchHelper(int[] array, int start, int end, int target) {
//        if (start > end) {
//            return -1;
//        }
//
//        int mid = (start + end) / 2;
//        if (array[mid] == target) {
//            return mid;
//        }
//
//        if (array[start] <= array[mid]) {
//            if (target >= array[start] && target < array[mid]) {
//                return shiftedBinarySearchHelper(array, start, mid - 1, target);
//            } else {
//                return shiftedBinarySearchHelper(array, mid + 1, end, target);
//            }
//        } else {
//            if (target <= array[end] && target > array[mid]) {
//                return shiftedBinarySearchHelper(array, mid + 1, end, target);
//            } else {
//                return shiftedBinarySearchHelper(array, start, mid - 1, target);
//            }
//        }
//    }


    //O(log(n)) time | O(1) space
    private static int shiftedBinarySearchHelper(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            }

            if (array[start] <= array[mid]) {
                if (target >= array[start] && target < array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= array[end] && target > array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}



/*
Test Cases
Test Case 1
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 33
    }
    Test Case 2
    {
    "array": [5, 23, 111, 1],
    "target": 111
    }
    Test Case 3
    {
    "array": [111, 1, 5, 23],
    "target": 5
    }
    Test Case 4
    {
    "array": [23, 111, 1, 5],
    "target": 35
    }
    Test Case 5
    {
    "array": [61, 71, 72, 73, 0, 1, 21, 33, 37, 45],
    "target": 33
    }
    Test Case 6
    {
    "array": [72, 73, 0, 1, 21, 33, 37, 45, 61, 71],
    "target": 72
    }
    Test Case 7
    {
    "array": [71, 72, 73, 0, 1, 21, 33, 37, 45, 61],
    "target": 73
    }
    Test Case 8
    {
    "array": [73, 0, 1, 21, 33, 37, 45, 61, 71, 72],
    "target": 70
    }
    Test Case 9
    {
    "array": [33, 37, 45, 61, 71, 72, 73, 355, 0, 1, 21],
    "target": 355
    }
    Test Case 10
    {
    "array": [33, 37, 45, 61, 71, 72, 73, 355, 0, 1, 21],
    "target": 354
    }
    Test Case 11
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 45
    }
    Test Case 12
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 61
    }
    Test Case 13
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 71
    }
    Test Case 14
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 72
    }
    Test Case 15
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 73
    }
    Test Case 16
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 0
    }
    Test Case 17
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 1
    }
    Test Case 18
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 21
    }
    Test Case 19
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 37
    }
    Test Case 20
    {
    "array": [45, 61, 71, 72, 73, 0, 1, 21, 33, 37],
    "target": 38
    }
    Test Case 21
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 0
    }
    Test Case 22
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 1
    }
    Test Case 23
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 21
    }
    Test Case 24
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 33
    }
    Test Case 25
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 37
    }
    Test Case 26
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 45
    }
    Test Case 27
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 61
    }
    Test Case 28
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 71
    }
    Test Case 29
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 72
    }
    Test Case 30
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 73
    }
    Test Case 31
    {
    "array": [0, 1, 21, 33, 37, 45, 61, 71, 72, 73],
    "target": 38
    }
*/
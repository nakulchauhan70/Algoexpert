package com.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        input.add(new ArrayList<>(Arrays.asList(2, 5, 9, 11)));
        input.add(new ArrayList<>(Arrays.asList(6, 8, 12, 15)));
        input.add(new ArrayList<>(Arrays.asList(7, 13, 14, 16)));

        System.out.println(zigzagTraverse(input));
    }

    //O(n) time | O(1) auxiliary space(not required actually traversing - returning O(n) space contained elements
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> traverse = new ArrayList<>();
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        int rowNo = 0;
        int colNo = 0;
        boolean goingDown = true;

        while (!isOutOfBound(rowNo, colNo, height, width)) {
            traverse.add(array.get(rowNo).get(colNo));

            if (goingDown) {
                if (colNo == 0 || rowNo == height) {
                    goingDown = false; //go right(diagonally)/down - True go right/down(diagonally)
                    if (rowNo == height) {
                        colNo++;
                    } else {
                        rowNo++;
                    }
                } else {
                    rowNo++;
                    colNo--;
                }
            } else {
                if (rowNo == 0 || colNo == width) {
                    goingDown = true;
                    if (colNo == width) {
                        rowNo++;
                    } else {
                        colNo++;
                    }
                } else {
                    rowNo--;
                    colNo++;
                }
            }
        }

        return traverse;
    }

    private static boolean isOutOfBound(int rowNo, int colNo, int height, int width) {
        return rowNo < 0 || rowNo > height || colNo < 0 || colNo > width;
    }
}

/*
Test Cases
Test Case 1
    {
    "array": [
    [1, 3, 4, 10],
    [2, 5, 9, 11],
    [6, 8, 12, 15],
    [7, 13, 14, 16]
    ]
    }
    Test Case 2
    {
    "array": [
    [1]
    ]
    }
    Test Case 3
    {
    "array": [
    [1, 2, 3, 4, 5]
    ]
    }
    Test Case 4
    {
    "array": [
    [1],
    [2],
    [3],
    [4],
    [5]
    ]
    }
    Test Case 5
    {
    "array": [
    [1, 3],
    [2, 4],
    [5, 7],
    [6, 8],
    [9, 10]
    ]
    }
    Test Case 6
    {
    "array": [
    [1, 3, 4, 7, 8],
    [2, 5, 6, 9, 10]
    ]
    }
    Test Case 7
    {
    "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 19],
    [6, 8, 13, 18, 20],
    [7, 14, 17, 21, 24],
    [15, 16, 22, 23, 25]
    ]
    }
    Test Case 8
    {
    "array": [
    [1, 3, 4, 10, 11, 20],
    [2, 5, 9, 12, 19, 21],
    [6, 8, 13, 18, 22, 27],
    [7, 14, 17, 23, 26, 28],
    [15, 16, 24, 25, 29, 30]
    ]
    }
    Test Case 9
    {
    "array": [
    [1, 3, 4, 10, 11],
    [2, 5, 9, 12, 20],
    [6, 8, 13, 19, 21],
    [7, 14, 18, 22, 27],
    [15, 17, 23, 26, 28],
    [16, 24, 25, 29, 30]
    ]
    }
    Test Case 10
    {
    "array": [
    [1, 21, -3, 4, 15, 6, -7, 88, 9],
    [10, 11, 112, 12, 20, -1, -2, -3, -4],
    [6, 8, 113, 19, 21, 0, 0, 0, 0],
    [7, 2, 18, 22, -27, 12, 32, -111, 66],
    [15, 17, 23, 226, 28, -28, -226, -23, -17],
    [16, 24, 27, 299, 30, 29, 32, 31, 88]
    ]
    }
*/

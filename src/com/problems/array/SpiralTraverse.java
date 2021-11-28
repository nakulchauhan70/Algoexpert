package com.problems.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        var input =
                new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        spiralTraverse(input).forEach(System.out::println);
    }

    //Iterative approach
    //O(n) time | O(n) space
//    public static List<Integer> spiralTraverse(int[][] array) {
//        List<Integer> updatedArray = new ArrayList<>();
//
//        if (array.length == 0)
//            return updatedArray;
//
//        int startRow = 0;
//        int endRow = array.length - 1;
//        int startCol = 0;
//        int endCol = array[0].length - 1;
//
//        while (startRow <= endRow && startCol <= endCol) {
//            for (int i = startCol; i <= endCol; i++) {
//                updatedArray.add(array[startRow][i]);
//            }
//
//            for (int i = startRow + 1; i <= endRow; i++) {
//                updatedArray.add(array[i][endCol]);
//            }
//
//            for (int i = endCol - 1; i >= startCol; i--) {
//                //Edge case - Single row in the middle of matrix
//                //Test case 8
//                if (startRow == endRow) break;
//                updatedArray.add(array[endRow][i]);
//            }
//
//            for (int i = endRow - 1; i > startRow; i--) {
//                //Edge case - Single column in the middle of matrix
//                //Test case 9
//                if (startCol == endCol) break;
//                updatedArray.add(array[i][startCol]);
//            }
//
//            startRow++;
//            endRow--;
//            startCol++;
//            endCol--;
//        }
//
//        return updatedArray;
//    }

    //Recursive approach
    //O(n) time | O(n) space
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> updatedArray = new ArrayList<>();
        if (array.length == 0)
            return updatedArray;

        spiralTraverseHelper(array, 0, array.length - 1, 0, array[0].length - 1, updatedArray);
        return updatedArray;
    }

    private static void spiralTraverseHelper(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> updatedArray) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }

        for (int i = startCol; i <= endCol; i++) {
            updatedArray.add(array[startRow][i]);
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            updatedArray.add(array[i][endCol]);
        }

        for (int i = endCol - 1; i >= startCol; i--) {
            //Edge case - Single row in the middle of matrix
            //Test case 8
            if (startRow == endRow) break;
            updatedArray.add(array[endRow][i]);
        }

        //Observe this startRow + 1
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            //Edge case - Single column in the middle of matrix
            //Test case 9
            if (startCol == endCol) break;
            updatedArray.add(array[i][startCol]);
        }

        spiralTraverseHelper(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, updatedArray);
    }
}


/*
Test Cases

Test Case 1
{
"array": [
[1, 2, 3, 4],
[12, 13, 14, 5],
[11, 16, 15, 6],
[10, 9, 8, 7]
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
[1, 2],
[4, 3]
]
}
Test Case 4
{
"array": [
[1, 2, 3],
[8, 9, 4],
[7, 6, 5]
]
}
Test Case 5
{
"array": [
[19, 32, 33, 34, 25, 8],
[16, 15, 14, 13, 12, 11],
[18, 31, 36, 35, 26, 9],
[1, 2, 3, 4, 5, 6],
[20, 21, 22, 23, 24, 7],
[17, 30, 29, 28, 27, 10]
]
}
Test Case 6
{
"array": [
[4, 2, 3, 6, 7, 8, 1, 9, 5, 10],
[12, 19, 15, 16, 20, 18, 13, 17, 11, 14]
]
}
Test Case 7
{
"array": [
[27, 12, 35, 26],
[25, 21, 94, 11],
[19, 96, 43, 56],
[55, 36, 10, 18],
[96, 83, 31, 94],
[93, 11, 90, 16]
]
}
Test Case 8
{
"array": [
[1, 2, 3, 4],
[10, 11, 12, 5],
[9, 8, 7, 6]
]
}
Test Case 9
{
"array": [
[1, 2, 3],
[12, 13, 4],
[11, 14, 5],
[10, 15, 6],
[9, 8, 7]
]
}
Test Case 10
{
"array": [
[1, 11],
[2, 12],
[3, 13],
[4, 14],
[5, 15],
[6, 16],
[7, 17],
[8, 18],
[9, 19],
[10, 20]
]
}
Test Case 11
{
"array": [
[1, 3, 2, 5, 4, 7, 6]
]
}
Test Case 12
{
"array": [
[1],
[3],
[2],
[5],
[4],
[7],
[6]
]
}*/

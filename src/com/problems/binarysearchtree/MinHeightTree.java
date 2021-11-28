package com.problems.binarysearchtree;

import java.util.List;

public class MinHeightTree {
    public static void main(String[] args) {
        minHeightBst(List.of(1, 2, 5, 7, 10, 13, 14, 15, 22));
    }

    public static BST minHeightBst(List<Integer> array) {
//        return constructMinHeightHelper(array, null, 0, array.size() - 1);
        return constructMinHeightHelper(array, 0, array.size() - 1);
    }

    //O(n) time | O(n) space - where n = length of array
    private static BST constructMinHeightHelper(List<Integer> array, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }

        int midIndex = (startIndex + endIndex) / 2;
        int value = array.get(midIndex);

        BST bst = new BST(value);

        bst.left = constructMinHeightHelper(array, startIndex, midIndex - 1);
        bst.right = constructMinHeightHelper(array, midIndex + 1, endIndex);

        return bst;
    }


    //O(n) time | O(n) space - where n = length of array
//    private static BST constructMinHeightHelper(List<Integer> array, BST bst, int startIndex, int endIndex) {
//        if (endIndex < startIndex) {
//            return null;
//        }
//
//        int midIndex = (startIndex + endIndex) / 2;
//        int value = array.get(midIndex);
//
//        BST newBst = new BST(value);
//
//        if (bst == null) {
//            bst = new BST(value);
//        } else {
//            if (array.get(midIndex) < bst.value) {
//                bst.left = newBst;
//                bst = bst.left;
//            } else {
//                bst.right = newBst;
//                bst = bst.right;
//            }
//        }
//
//        constructMinHeightHelper(array, bst, startIndex, midIndex - 1);
//        constructMinHeightHelper(array, bst, midIndex + 1, endIndex);
//
//        return bst;
//    }

    //O(nlogn) time | O(n) space - where n = length of array, logn = time to insert
//    private static BST constructMinHeightHelper(List<Integer> array, BST bst, int startIndex, int endIndex) {
//        if (endIndex < startIndex) {
//            return null;
//        }
//
//        int midIndex = (startIndex + endIndex) / 2;
//        int value = array.get(midIndex);
//
//        if (bst == null) {
//            bst = new BST(value);
//        } else {
//            bst.insert(value);
//        }
//
//        constructMinHeightHelper(array, bst, startIndex, midIndex - 1);
//        constructMinHeightHelper(array, bst, midIndex + 1, endIndex);
//
//        return bst;
//    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}

/*
Test Cases
Test Case 1
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22]
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
    "array": [1, 2, 5]
    }
    Test Case 5
    {
    "array": [1, 2, 5, 7]
    }
    Test Case 6
    {
    "array": [1, 2, 5, 7, 10]
    }
    Test Case 7
    {
    "array": [1, 2, 5, 7, 10, 13]
    }
    Test Case 8
    {
    "array": [1, 2, 5, 7, 10, 13, 14]
    }
    Test Case 9
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15]
    }
    Test Case 10
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22]
    }
    Test Case 11
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28]
    }
    Test Case 12
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32]
    }
    Test Case 13
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36]
    }
    Test Case 14
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36, 89]
    }
    Test Case 15
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36, 89, 92]
    }
    Test Case 16
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36, 89, 92, 9000]
    }
    Test Case 17
    {
    "array": [1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36, 89, 92, 9000, 9001]
    }
*/
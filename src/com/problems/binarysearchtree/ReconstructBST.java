package com.problems.binarysearchtree;

import java.util.List;

public class ReconstructBST {
    public static void main(String[] args) {
        System.out.println(reconstructBst(List.of(10, 4, 2, 1, 5, 17, 19, 18)));
    }

    //O(n^2) time | O(n) space - where n = length of the input array
//    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
//        if (preOrderTraversalValues.size() == 0) {
//            return null;
//        }
//
//        int currentValue = preOrderTraversalValues.get(0);
//        int rightSubtreeRootIndex = preOrderTraversalValues.size();
//
//        for (int index = 1; index < preOrderTraversalValues.size(); index++) {
//            int value = preOrderTraversalValues.get(index);
//            if (value >= currentValue) {
//                rightSubtreeRootIndex = index;
//                break;
//            }
//        }
//
//        BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIndex));
//        BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIndex, preOrderTraversalValues.size()));
//
//        BST bst = new BST(currentValue);
//        bst.left = leftSubtree;
//        bst.right = rightSubtree;
//
//        return bst;
//    }

    //O(n) time | O(n) space - where n = length of the input array
    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    private static BST reconstructBSTFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues, TreeInfo currentSubtreeInfo) {
        if (currentSubtreeInfo.rootIndex == preOrderTraversalValues.size()) {
            return null;
        }

        int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIndex);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        currentSubtreeInfo.rootIndex++;

        BST leftSubtree = reconstructBSTFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);
        BST rightSubtree = reconstructBSTFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

        BST bst = new BST(rootValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;

        return bst;
    }

    static class TreeInfo {
        int rootIndex;

        public TreeInfo(int rootIndex) {
            this.rootIndex = rootIndex;
        }
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}

/*
Test Cases
Test Case 1
    {
    "preOrderTraversalValues": [10, 4, 2, 1, 5, 17, 19, 18]
    }
    Test Case 2
    {
    "preOrderTraversalValues": [100]
    }
    Test Case 3
    {
    "preOrderTraversalValues": [10, 9, 8, 7, 6, 5]
    }
    Test Case 4
    {
    "preOrderTraversalValues": [5, 6, 7, 8]
    }
    Test Case 5
    {
    "preOrderTraversalValues": [5, -10, -5, 6, 9, 7]
    }
    Test Case 6
    {
    "preOrderTraversalValues": [10, 4, 2, 1, 3, 5, 6, 9, 7, 17, 19, 18]
    }
    Test Case 7
    {
    "preOrderTraversalValues": [1, 0, 2]
    }
    Test Case 8
    {
    "preOrderTraversalValues": [2, 0, 1]
    }
    Test Case 9
    {
    "preOrderTraversalValues": [2, 0, 1, 4, 3]
    }
    Test Case 10
    {
    "preOrderTraversalValues": [2, 0, 1, 4, 3, 3]
    }
    Test Case 11
    {
    "preOrderTraversalValues": [2, 0, 1, 3, 4, 3]
    }
    Test Case 12
    {
    "preOrderTraversalValues": [10, 4, 2, 1, 3, 5, 5, 6, 5, 5, 9, 7, 17, 19, 18, 18, 19]
    }
*/
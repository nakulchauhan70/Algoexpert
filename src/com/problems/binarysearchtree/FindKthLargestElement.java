package com.problems.binarysearchtree;

import java.util.ArrayList;

public class FindKthLargestElement {
    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        int k = 3;
        int expected = 17;
        var actual = findKthLargestValueInBst(root, k);
        System.out.println(expected == actual);
    }

    //O(n) time | O(n) space - where n = no of nodes
//    public static int findKthLargestValueInBst(BST tree, int k) {
//        ArrayList<Integer> sortedNodeValues = new ArrayList<>();
//        inOrderTraverse(tree, sortedNodeValues);
//        return sortedNodeValues.get(sortedNodeValues.size() - k);
//    }

    private static void inOrderTraverse(BST tree, ArrayList<Integer> sortedNodeValues) {
        if (tree == null) {
            return;
        }

        inOrderTraverse(tree.left, sortedNodeValues);
        sortedNodeValues.add(tree.value);
        inOrderTraverse(tree.right, sortedNodeValues);
    }

    //O(h + k) time | O(h) space - where h = height of the tree and k = input parameter
    public static int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }

    private static void reverseInOrderTraverse(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null || treeInfo.noOfNodeVisited >= k) {
            return;
        }

        reverseInOrderTraverse(tree.right, k, treeInfo);
        if (treeInfo.noOfNodeVisited < k) {
            treeInfo.noOfNodeVisited += 1;
            treeInfo.latestVisitedNodeValue = tree.value;
            reverseInOrderTraverse(tree.left, k, treeInfo);
        }
    }

    static class TreeInfo {
        int noOfNodeVisited;
        int latestVisitedNodeValue;

        public TreeInfo(int noOfNodeVisited, int latestVisitedNodeValue) {
            this.noOfNodeVisited = noOfNodeVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
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
    "tree": {
    "nodes": [
    {"id": "15", "left": "5", "right": "20", "value": 15},
    {"id": "20", "left": "17", "right": "22", "value": 20},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "17", "left": null, "right": null, "value": 17},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "15"
    },
    "k": 3
    }
    Test Case 2
    {
    "tree": {
    "nodes": [
    {"id": "5", "left": "4", "right": "6", "value": 5},
    {"id": "4", "left": "3", "right": null, "value": 4},
    {"id": "6", "left": null, "right": "7", "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "3", "left": null, "right": null, "value": 3}
    ],
    "root": "5"
    },
    "k": 1
    }
    Test Case 3
    {
    "tree": {
    "nodes": [
    {"id": "5", "left": null, "right": null, "value": 5}
    ],
    "root": "5"
    },
    "k": 1
    }
    Test Case 4
    {
    "tree": {
    "nodes": [
    {"id": "20", "left": "15", "right": "25", "value": 20},
    {"id": "15", "left": "10", "right": "19", "value": 15},
    {"id": "25", "left": "21", "right": "30", "value": 25},
    {"id": "10", "left": null, "right": null, "value": 10},
    {"id": "19", "left": null, "right": null, "value": 19},
    {"id": "21", "left": null, "right": "22", "value": 21},
    {"id": "30", "left": null, "right": null, "value": 30},
    {"id": "22", "left": null, "right": null, "value": 22}
    ],
    "root": "20"
    },
    "k": 3
    }
    Test Case 5
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": null, "right": "2", "value": 1},
    {"id": "2", "left": null, "right": "3", "value": 2},
    {"id": "3", "left": null, "right": "4", "value": 3},
    {"id": "4", "left": null, "right": "5", "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5}
    ],
    "root": "1"
    },
    "k": 5
    }
    Test Case 6
    {
    "tree": {
    "nodes": [
    {"id": "10", "left": "8", "right": null, "value": 10},
    {"id": "8", "left": "6", "right": null, "value": 8},
    {"id": "6", "left": "4", "right": null, "value": 6},
    {"id": "4", "left": "2", "right": null, "value": 4},
    {"id": "2", "left": null, "right": null, "value": 2}
    ],
    "root": "10"
    },
    "k": 2
    }
    Test Case 7
    {
    "tree": {
    "nodes": [
    {"id": "10", "left": "8", "right": null, "value": 10},
    {"id": "8", "left": "6", "right": "9", "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9},
    {"id": "6", "left": "4", "right": "7", "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "4", "left": "2", "right": "5", "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "2", "left": null, "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3}
    ],
    "root": "10"
    },
    "k": 5
    }
    Test Case 8
    {
    "tree": {
    "nodes": [
    {"id": "99727", "left": "99", "right": null, "value": 99727},
    {"id": "99", "left": null, "right": "727", "value": 99},
    {"id": "727", "left": null, "right": null, "value": 727}
    ],
    "root": "99727"
    },
    "k": 1
    }
    Test Case 9
    {
    "tree": {
    "nodes": [
    {"id": "15", "left": "5", "right": "20", "value": 15},
    {"id": "20", "left": "17", "right": "22", "value": 20},
    {"id": "22", "left": null, "right": "24", "value": 22},
    {"id": "24", "left": "23", "right": "25", "value": 24},
    {"id": "23", "left": null, "right": null, "value": 23},
    {"id": "25", "left": null, "right": null, "value": 25},
    {"id": "17", "left": null, "right": null, "value": 17},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "15"
    },
    "k": 7
    }
    Test Case 10
    {
    "tree": {
    "nodes": [
    {"id": "15", "left": "5", "right": "20", "value": 15},
    {"id": "20", "left": "17", "right": "22", "value": 20},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "17", "left": null, "right": null, "value": 17},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "15"
    },
    "k": 5
    }
    Test Case 11
    {
    "tree": {
    "nodes": [
    {"id": "15", "left": "5", "right": "20", "value": 15},
    {"id": "20", "left": "17", "right": "22", "value": 20},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "17", "left": null, "right": null, "value": 17},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "15"
    },
    "k": 6
    }
*/
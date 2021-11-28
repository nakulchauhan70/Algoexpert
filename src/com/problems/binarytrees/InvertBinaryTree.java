package com.problems.binarytrees;

import java.util.ArrayDeque;

public class InvertBinaryTree {
    public static void main(String[] args) {
    }

    //Iterative Approach
    //O(n) time | O(n) space
    public static void invertBinaryTree(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(tree);//addLast

        while (!queue.isEmpty()) {
            BinaryTree currentNode = queue.pollFirst();
            swapLeftRight(currentNode);
            if (currentNode.left != null) {
                queue.add(currentNode.left);//addLast
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);//addLast
            }
        }
    }

    //Recursive Approach
    //O(n) time | O(d) space - where d is depth or height of the tree
//    public static void invertBinaryTree(BinaryTree tree) {
//        if (tree == null) {
//            return;
//        }
//
//        swapLeftRight(tree);
//        invertBinaryTree(tree.left);
//        invertBinaryTree(tree.right);
//    }

    private static void swapLeftRight(BinaryTree currentNode) {
        BinaryTree temp = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
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
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": "8", "right": "9", "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": null, "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9}
    ],
    "root": "1"
    }
    }
    Test Case 2
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "1"
    }
    }
    Test Case 3
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": null, "value": 1},
    {"id": "2", "left": null, "right": null, "value": 2}
    ],
    "root": "1"
    }
    }
    Test Case 4
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": null, "right": null, "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3}
    ],
    "root": "1"
    }
    }
    Test Case 5
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": null, "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "4", "left": null, "right": null, "value": 4}
    ],
    "root": "1"
    }
    }
    Test Case 6
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "4", "left": null, "right": null, "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5}
    ],
    "root": "1"
    }
    }
    Test Case 7
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": null, "value": 3},
    {"id": "4", "left": null, "right": null, "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6}
    ],
    "root": "1"
    }
    }
    Test Case 8
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": null, "right": null, "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7}
    ],
    "root": "1"
    }
    }
    Test Case 9
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": "8", "right": null, "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": null, "value": 8}
    ],
    "root": "1"
    }
    }
    Test Case 10
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": "8", "right": "9", "value": 4},
    {"id": "5", "left": "10", "right": null, "value": 5},
    {"id": "6", "left": null, "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": null, "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9},
    {"id": "10", "left": null, "right": null, "value": 10}
    ],
    "root": "1"
    }
    }
    Test Case 11
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "3", "value": 1},
    {"id": "2", "left": "4", "right": "5", "value": 2},
    {"id": "3", "left": "6", "right": "7", "value": 3},
    {"id": "4", "left": "8", "right": "9", "value": 4},
    {"id": "5", "left": "10", "right": null, "value": 5},
    {"id": "6", "left": null, "right": "11", "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": "12", "value": 8},
    {"id": "9", "left": "13", "right": "14", "value": 9},
    {"id": "10", "left": null, "right": null, "value": 10},
    {"id": "11", "left": "15", "right": "16", "value": 11},
    {"id": "12", "left": null, "right": null, "value": 12},
    {"id": "13", "left": null, "right": null, "value": 13},
    {"id": "14", "left": null, "right": null, "value": 14},
    {"id": "15", "left": null, "right": "17", "value": 15},
    {"id": "16", "left": null, "right": null, "value": 16},
    {"id": "17", "left": null, "right": "18", "value": 17},
    {"id": "18", "left": null, "right": "19", "value": 18},
    {"id": "19", "left": "20", "right": null, "value": 19},
    {"id": "20", "left": "21", "right": null, "value": 20},
    {"id": "21", "left": null, "right": null, "value": 21}
    ],
    "root": "1"
    }
    }
*/
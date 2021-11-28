package com.problems.binarytrees;

public class NodeDepth {
    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(nodeDepths(root));
    }

    //Iterative Approach
    //O(n) time | O(h) space - where n = no of nodes and h = height of tree
//    public static int nodeDepths(BinaryTree root) {
//        int sumOfDepth = 0;
//        List<Level> stack = new ArrayList<>();
//        stack.add(new Level(root, 0));
//
//        while (!stack.isEmpty()) {
//            Level top = stack.remove(stack.size() - 1);
//            BinaryTree node = top.root;
//            int depth = top.depth;
//
//            if (node == null)
//                continue;
//
//            sumOfDepth += depth;
//            stack.add(new Level(node.left, depth + 1));
//            stack.add(new Level(node.right, depth + 1));
//        }
//
//        return sumOfDepth;
//    }

    //Recursive Approach
    //O(n) time | O(h) space - where n = no of nodes and h = height of tree
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthHelper(root, 0);
    }

    private static int nodeDepthHelper(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + nodeDepthHelper(node.left, depth + 1) + nodeDepthHelper(node.right, depth + 1);
    }

    static class Level {
        BinaryTree root;
        int depth;

        public Level(BinaryTree root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
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
    {"id": "1", "left": "2", "right": null, "value": 1},
    {"id": "2", "left": "3", "right": null, "value": 2},
    {"id": "3", "left": "4", "right": null, "value": 3},
    {"id": "4", "left": "5", "right": null, "value": 4},
    {"id": "5", "left": "6", "right": null, "value": 5},
    {"id": "6", "left": null, "right": "7", "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7}
    ],
    "root": "1"
    }
    }
    Test Case 7
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": "8", "value": 1},
    {"id": "2", "left": "3", "right": null, "value": 2},
    {"id": "3", "left": "4", "right": null, "value": 3},
    {"id": "4", "left": "5", "right": null, "value": 4},
    {"id": "5", "left": "6", "right": null, "value": 5},
    {"id": "6", "left": null, "right": "7", "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": "9", "value": 8},
    {"id": "9", "left": null, "right": "10", "value": 9},
    {"id": "10", "left": null, "right": "11", "value": 10},
    {"id": "11", "left": null, "right": "12", "value": 11},
    {"id": "12", "left": "13", "right": null, "value": 12},
    {"id": "13", "left": null, "right": null, "value": 13}
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
    {"id": "4", "left": "8", "right": "9", "value": 4},
    {"id": "5", "left": null, "right": null, "value": 5},
    {"id": "6", "left": "10", "right": null, "value": 6},
    {"id": "7", "left": null, "right": null, "value": 7},
    {"id": "8", "left": null, "right": null, "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9},
    {"id": "10", "left": null, "right": "11", "value": 10},
    {"id": "11", "left": "12", "right": "13", "value": 11},
    {"id": "12", "left": "14", "right": null, "value": 12},
    {"id": "13", "left": "15", "right": "16", "value": 13},
    {"id": "14", "left": null, "right": null, "value": 14},
    {"id": "15", "left": null, "right": null, "value": 15},
    {"id": "16", "left": null, "right": null, "value": 16}
    ],
    "root": "1"
    }
    }
    Test Case 9
    {
    "tree": {
    "nodes": [
    {"id": "1", "left": "2", "right": null, "value": 1},
    {"id": "2", "left": "3", "right": null, "value": 2},
    {"id": "3", "left": "4", "right": null, "value": 3},
    {"id": "4", "left": "5", "right": null, "value": 4},
    {"id": "5", "left": "6", "right": null, "value": 5},
    {"id": "6", "left": "7", "right": null, "value": 6},
    {"id": "7", "left": "8", "right": null, "value": 7},
    {"id": "8", "left": "9", "right": null, "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9}
    ],
    "root": "1"
    }
    }
*/
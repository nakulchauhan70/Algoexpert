package com.problems.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {
    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);

//        List<Integer> inOrder = Arrays.asList(new Integer[]{1, 2, 5, 5, 10, 15, 22});
//        List<Integer> preOrder = Arrays.asList(new Integer[]{10, 5, 2, 1, 5, 15, 22});
//        List<Integer> postOrder = Arrays.asList(new Integer[]{1, 2, 5, 5, 22, 15, 10});

        inOrderTraverse(root, new ArrayList<>());
        preOrderTraverse(root, new ArrayList<>());
        postOrderTraverse(root, new ArrayList<>());
    }

    //O(n) time | O(n) space
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    //O(n) time | O(n) space
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    //O(n) time | O(n) space
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);

        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

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
    {"id": "10", "left": "5", "right": "15", "value": 10},
    {"id": "15", "left": null, "right": "22", "value": 15},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": null, "value": 2},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "10"
    }
    }
    Test Case 2
    {
    "tree": {
    "nodes": [
    {"id": "100", "left": "5", "right": "502", "value": 100},
    {"id": "502", "left": "204", "right": "55000", "value": 502},
    {"id": "55000", "left": "1001", "right": null, "value": 55000},
    {"id": "1001", "left": null, "right": "4500", "value": 1001},
    {"id": "4500", "left": null, "right": null, "value": 4500},
    {"id": "204", "left": "203", "right": "205", "value": 204},
    {"id": "205", "left": null, "right": "207", "value": 205},
    {"id": "207", "left": "206", "right": "208", "value": 207},
    {"id": "208", "left": null, "right": null, "value": 208},
    {"id": "206", "left": null, "right": null, "value": 206},
    {"id": "203", "left": null, "right": null, "value": 203},
    {"id": "5", "left": "2", "right": "15", "value": 5},
    {"id": "15", "left": "5-2", "right": "22", "value": 15},
    {"id": "22", "left": null, "right": "57", "value": 22},
    {"id": "57", "left": null, "right": "60", "value": 57},
    {"id": "60", "left": null, "right": null, "value": 60},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": "-51", "right": "1-2", "value": 1},
    {"id": "1-2", "left": null, "right": "1-3", "value": 1},
    {"id": "1-3", "left": null, "right": "1-4", "value": 1},
    {"id": "1-4", "left": null, "right": "1-5", "value": 1},
    {"id": "1-5", "left": null, "right": null, "value": 1},
    {"id": "-51", "left": "-403", "right": null, "value": -51},
    {"id": "-403", "left": null, "right": null, "value": -403}
    ],
    "root": "100"
    }
    }
    Test Case 3
    {
    "tree": {
    "nodes": [
    {"id": "10", "left": "5", "right": "15", "value": 10},
    {"id": "15", "left": null, "right": "22", "value": 15},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": null, "value": 2},
    {"id": "1", "left": "-5", "right": null, "value": 1},
    {"id": "-5", "left": "-15", "right": "-5-2", "value": -5},
    {"id": "-5-2", "left": null, "right": "-2", "value": -5},
    {"id": "-2", "left": null, "right": "-1", "value": -2},
    {"id": "-1", "left": null, "right": null, "value": -1},
    {"id": "-15", "left": "-22", "right": null, "value": -15},
    {"id": "-22", "left": null, "right": null, "value": -22}
    ],
    "root": "10"
    }
    }
    Test Case 4
    {
    "tree": {
    "nodes": [
    {"id": "10", "left": null, "right": null, "value": 10}
    ],
    "root": "10"
    }
    }
    Test Case 5
    {
    "tree": {
    "nodes": [
    {"id": "10", "left": "5", "right": "15", "value": 10},
    {"id": "15", "left": null, "right": "22", "value": 15},
    {"id": "22", "left": null, "right": "500", "value": 22},
    {"id": "500", "left": "50", "right": "1500", "value": 500},
    {"id": "1500", "left": null, "right": "10000", "value": 1500},
    {"id": "10000", "left": "2200", "right": null, "value": 10000},
    {"id": "2200", "left": null, "right": null, "value": 2200},
    {"id": "50", "left": null, "right": "200", "value": 50},
    {"id": "200", "left": null, "right": null, "value": 200},
    {"id": "5", "left": "2", "right": "5-2", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": null, "value": 2},
    {"id": "1", "left": null, "right": null, "value": 1}
    ],
    "root": "10"
    }
    }
    Test Case 6
    {
    "tree": {
    "nodes": [
    {"id": "5000", "left": "5", "right": "55000", "value": 5000},
    {"id": "55000", "left": null, "right": null, "value": 55000},
    {"id": "5", "left": "2", "right": "15", "value": 5},
    {"id": "15", "left": "5-2", "right": "22", "value": 15},
    {"id": "22", "left": null, "right": "502", "value": 22},
    {"id": "502", "left": "204", "right": null, "value": 502},
    {"id": "204", "left": "203", "right": "205", "value": 204},
    {"id": "205", "left": null, "right": "207", "value": 205},
    {"id": "207", "left": "206", "right": "208", "value": 207},
    {"id": "208", "left": null, "right": null, "value": 208},
    {"id": "206", "left": null, "right": null, "value": 206},
    {"id": "203", "left": null, "right": null, "value": 203},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": null, "right": "1-2", "value": 1},
    {"id": "1-2", "left": null, "right": "1-3", "value": 1},
    {"id": "1-3", "left": null, "right": "1-4", "value": 1},
    {"id": "1-4", "left": null, "right": "1-5", "value": 1},
    {"id": "1-5", "left": null, "right": null, "value": 1}
    ],
    "root": "5000"
    }
    }
*/
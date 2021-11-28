package com.problems.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan2 {
    public static void main(String[] args) {
        System.out.println(rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2)));
    }

    //Optimal Solution
    //O(nlogn) time | O(n) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<>();
        }

        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        int lastIndex = array.size() - 1;

        SpecialBST bst = new SpecialBST(array.get(lastIndex));
        rightSmallerCounts.set(lastIndex, 0);
        //Construct BST
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, rightSmallerCounts, 0);
        }

        return rightSmallerCounts;
    }

    static class SpecialBST {
        int value;
        int leftSubTreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
        }

        public void insert(Integer value, int index, List<Integer> rightSmallerCounts, int numSmallerAtInsertTime) {
            if (value < this.value) {
                this.leftSubTreeSize++;
                if (this.left == null) {
                    this.left = new SpecialBST(value);
                    rightSmallerCounts.set(index, numSmallerAtInsertTime);
                } else {
                    this.left.insert(value, index, rightSmallerCounts, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += this.leftSubTreeSize;
                if (value > this.value) {
                    numSmallerAtInsertTime++;
                }
                if (this.right == null) {
                    this.right = new SpecialBST(value);
                    rightSmallerCounts.set(index, numSmallerAtInsertTime);
                } else {
                    this.right.insert(value, index, rightSmallerCounts, numSmallerAtInsertTime);
                }
            }
        }
    }
}

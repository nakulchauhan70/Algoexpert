package com.problems.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {
    public static void main(String[] args) {
        System.out.println(rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2)));
    }

    //Brute force - Naive solution
    //O(n^2) time | O(n) space
//    public static List<Integer> rightSmallerThan(List<Integer> array) {
//        List<Integer> rightSmallerCounts = new ArrayList<>();
//        for (int i = 0; i < array.size(); i++) {
//            int rightSmallerCount = 0;
//            for (int j = i + 1; j < array.size(); j++) {
//                if (array.get(j) < array.get(i)) {
//                    rightSmallerCount++;
//                }
//            }
//            rightSmallerCounts.add(rightSmallerCount);
//        }
//        return rightSmallerCounts;
//    }

    //Optimal Solution
    //O(nlogn) time | O(n) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<>();
        }

        int lastIndex = array.size() - 1;

        SpecialBST bst = new SpecialBST(array.get(lastIndex), lastIndex, 0);

        //Construct BST
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, 0);
        }

        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        getRightSmallerCounts(bst, rightSmallerCounts);
        return rightSmallerCounts;
    }

    private static void getRightSmallerCounts(SpecialBST bst, List<Integer> rightSmallerCounts) {
        if (bst == null) {
            return;
        }

        rightSmallerCounts.set(bst.index, bst.numSmallerAtInsertTime);
        getRightSmallerCounts(bst.left, rightSmallerCounts);
        getRightSmallerCounts(bst.right, rightSmallerCounts);
    }

    static class SpecialBST {
        int value;
        int index;
        int numSmallerAtInsertTime;
        int leftSubTreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value, int index, int numSmallerAtInsertTime) {
            this.value = value;
            this.index = index;
            this.numSmallerAtInsertTime = numSmallerAtInsertTime;
        }

        public void insert(Integer value, int index, int numSmallerAtInsertTime) {
            if (value < this.value) {
                this.leftSubTreeSize++;
                if (this.left == null) {
                    this.left = new SpecialBST(value, index, numSmallerAtInsertTime);
                } else {
                    this.left.insert(value, index, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += this.leftSubTreeSize;
                if (value > this.value) {
                    numSmallerAtInsertTime++;
                }
                if (this.right == null) {
                    this.right = new SpecialBST(value, index, numSmallerAtInsertTime);
                } else {
                    this.right.insert(value, index, numSmallerAtInsertTime);
                }
            }
        }
    }

}

/*
Test Cases
Test Case 1
    {
    "array": [8, 5, 11, -1, 3, 4, 2]
    }
    Test Case 2
    {
    "array": []
    }
    Test Case 3
    {
    "array": [1]
    }
    Test Case 4
    {
    "array": [0, 1, 1, 2, 3, 5, 8, 13]
    }
    Test Case 5
    {
    "array": [13, 8, 5, 3, 2, 1, 1, 0]
    }
    Test Case 6
    {
    "array": [8, 5, 2, 9, 5, 6, 3]
    }
    Test Case 7
    {
    "array": [991, -731, -882, 100, 280, -43, 432, 771, -581, 180, -382, -998, 847, 80, -220, 680, 769, -75, -817, 366, 956, 749, 471, 228, -435, -269, 652, -331, -387, -657, -255, 382, -216, -6, -163, -681, 980, 913, -169, 972, -523, 354, 747, 805, 382, -827, -796, 372, 753, 519, 906]
    }
    Test Case 8
    {
    "array": [384, -67, 120, 759, 697, 232, -7, -557, -772, -987, 687, 397, -763, -86, -491, 947, 921, 421, 825, -679, 946, -562, -626, -898, 204, 776, -343, 393, 51, -796, -425, 31, 165, 975, -720, 878, -785, -367, -609, 662, -79, -112, -313, -94, 187, 260, 43, 85, -746, 612, 67, -389, 508, 777, 624, 993, -581, 34, 444, -544, 243, -995, 432, -755, -978, 515, -68, -559, 489, 732, -19, -489, 737, 924]
    }
    Test Case 9
    {
    "array": [-823, 164, 48, -987, 323, 399, -293, 183, -908, -376, 14, 980, 965, 842, 422, 829, 59, 724, -415, -733, 356, -855, -155, 52, 328, -544, -371, -160, -942, -51, 700, -363, -353, -359, 238, 892, -730, -575, 892, 490, 490, 995, 572, 888, -935, 919, -191, 646, -120, 125, -817, 341, -575, 372, -874, 243, 610, -36, -685, -337, -13, 295, 800, -950, -949, -257, 631, -542, 201, -796, 157, 950, 540, -846, -265, 746, 355, -578, -441, -254, -941, -738, -469, -167, -420, -126, -410, 59]
    }
*/

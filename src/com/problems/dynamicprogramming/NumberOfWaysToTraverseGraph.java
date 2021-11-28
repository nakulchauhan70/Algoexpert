package com.problems.dynamicprogramming;

public class NumberOfWaysToTraverseGraph {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4, 3));
    }

    //Non-optimal solution
    //O(2^(n + m)) time | O(n + m) space
//    public static int numberOfWaysToTraverseGraph(int width, int height) {
//        if (height == 1 || width == 1) {
//            return 1;
//        }
//        return numberOfWaysToTraverseGraph(width - 1, height) + numberOfWaysToTraverseGraph(width, height - 1);
//    }

    //Optimal solution
    //O(n * m) time | O(n * m) space - where n = width, m = height of the graph
//    public static int numberOfWaysToTraverseGraph(int width, int height) {
//        int[][] noOfWays = new int[height + 1][width + 1];
//
//        for (int widthIndex = 1; widthIndex < width + 1; widthIndex++) {
//            for (int heightIndex = 1; heightIndex < height + 1; heightIndex++) {
//                if (widthIndex == 1 || heightIndex == 1) {
//                    noOfWays[heightIndex][widthIndex] = 1;
//                } else {
//                    int wayLeft = noOfWays[heightIndex][widthIndex - 1];
//                    int waysUp = noOfWays[heightIndex - 1][widthIndex];
//                    noOfWays[heightIndex][widthIndex] = wayLeft + waysUp;
//                }
//            }
//        }
//
//        return noOfWays[height][width];
//    }

    //Using math formula - not recommended in interview
    //O(n + m) time | O(1) space - where n = width, m = height of the graph
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int xDistanceToCorner = width - 1;
        int yDistanceToCorner = height - 1;

        // The number of permutations of right and down movements is the no of ways to reach the bottom right corner
        int numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        int denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);
        return numerator / denominator;
    }

    private static int factorial(int num) {
        int result = 1;

        for (int n = 2; n < num + 1; n++) {
            result *= n;
        }

        return result;
    }
}

/*
Test Cases
Test Case 1
    {
    "width": 4,
    "height": 3
    }
    Test Case 2
    {
    "width": 3,
    "height": 2
    }
    Test Case 3
    {
    "width": 2,
    "height": 3
    }
    Test Case 4
    {
    "width": 5,
    "height": 5
    }
    Test Case 5
    {
    "width": 5,
    "height": 6
    }
    Test Case 6
    {
    "width": 7,
    "height": 5
    }
    Test Case 7
    {
    "width": 10,
    "height": 2
    }
    Test Case 8
    {
    "width": 11,
    "height": 2
    }
    Test Case 9
    {
    "width": 5,
    "height": 9
    }
    Test Case 10
    {
    "width": 6,
    "height": 7
    }
    Test Case 11
    {
    "width": 8,
    "height": 5
    }
    Test Case 12
    {
    "width": 2,
    "height": 2
    }
    Test Case 13
    {
    "width": 2,
    "height": 1
    }
    Test Case 14
    {
    "width": 1,
    "height": 2
    }
    Test Case 15
    {
    "width": 3,
    "height": 3
    }
*/

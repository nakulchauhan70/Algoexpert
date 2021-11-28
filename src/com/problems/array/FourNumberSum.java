package com.problems.array;

import java.util.*;

public class FourNumberSum {
    public static void main(String[] args) {
        fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16).forEach(q -> System.out.println(Arrays.toString(q)));
        fourNumberSum(new int[]{5, -5, -2, 2, 3, -3}, 0).forEach(q -> System.out.println(Arrays.toString(q)));
    }

    //O(n^2) (avg), O(n^3) (worst) time | O(n^2) space
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> allPairsSum = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;

                if (allPairsSum.containsKey(difference)) {
                    for (Integer[] pair : allPairsSum.get(difference)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i], array[k]};
                if (!allPairsSum.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    allPairsSum.put(currentSum, pairGroup);
                } else {
                    allPairsSum.get(currentSum).add(pair);
                }
            }
        }

        return quadruplets;
    }
}

//Test Cases
/*
Test Case 1
{
"array": [7, 6, 4, -1, 1, 2],
"targetSum": 16
}
Test Case 2
{
"array": [1, 2, 3, 4, 5, 6, 7],
"targetSum": 10
}
Test Case 3
{
"array": [5, -5, -2, 2, 3, -3],
"targetSum": 0
}
Test Case 4
{
"array": [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9],
"targetSum": 4
}
Test Case 5
{
"array": [-1, 22, 18, 4, 7, 11, 2, -5, -3],
"targetSum": 30
}
Test Case 6
{
"array": [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5],
"targetSum": 20
}
Test Case 7
{
"array": [1, 2, 3, 4, 5],
"targetSum": 100
}
Test Case 8
{
"array": [1, 2, 3, 4, 5, -5, 6, -6],
"targetSum": 5
}*/

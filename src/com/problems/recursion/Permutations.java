package com.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
//        getPermutations(Arrays.asList(1, 2, 3)).forEach(System.out::println);
        getPermutations(Arrays.asList(1, 2, 3, 4, 5)).forEach(System.out::println);
    }

    //Upper bound: O(n^2) time | O(n*n!) space
    //Roughly: O(n*n!) time | O(n*n!) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutationHelper(array, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void permutationHelper(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                permutationHelper(newArray, newPermutation, permutations);
            }
        }
    }
}


//Test Cases
/*
Test Case 1
{
"array": [1, 2, 3]
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
"array": [1, 2]
}
Test Case 5
{
"array": [1, 2, 3, 4]
}
Test Case 6
{
"array": [1, 2, 3, 4, 5]
}*/

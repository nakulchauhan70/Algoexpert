package com.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)));
    }

    // O(n^2) time | O(1) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[i];
                if (firstNum + secondNum == targetSum) {
                    return new int[]{firstNum, secondNum};
                }
            }
        }

        return new int[0];
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum1(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            int y = targetSum - x;
            if (set.contains(y)) {
                return new int[]{x, y};
            } else {
                set.add(x);
            }
        }
        return new int[0];
    }

    //O(nlogn) time | O(1) space
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;
        int sum;

        while (left < right) {
            sum = array[left] + array[right];

            if (sum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}

//Test Cases
/*
Test Case 1
{
"array": [3, 5, -4, 8, 11, 1, -1, 6],
"targetSum": 10
}
Test Case 2
{
"array": [4, 6],
"targetSum": 10
}
Test Case 3
{
"array": [4, 6, 1],
"targetSum": 5
}
Test Case 4
{
"array": [4, 6, 1, -3],
"targetSum": 3
}
Test Case 5
{
"array": [1, 2, 3, 4, 5, 6, 7, 8, 9],
"targetSum": 17
}
Test Case 6
{
"array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15],
"targetSum": 18
}
Test Case 7
{
"array": [-7, -5, -3, -1, 0, 1, 3, 5, 7],
"targetSum": -5
}
Test Case 8
{
"array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47],
"targetSum": 163
}
Test Case 9
{
"array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47],
"targetSum": 164
}
Test Case 10
{
"array": [3, 5, -4, 8, 11, 1, -1, 6],
"targetSum": 15
}
Test Case 11
{
"array": [14],
"targetSum": 15
}
Test Case 12
{
"array": [15],
"targetSum": 15
}*/

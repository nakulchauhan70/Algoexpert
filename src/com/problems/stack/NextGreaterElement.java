package com.problems.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 5, -3, -4, 6, 7, 2})));
    }

    //O(n) time | O(n) space - where n = length of array
//    public static int[] nextGreaterElement(int[] array) {
//        int[] result = new int[array.length];
//        Arrays.fill(result, -1);
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < array.length * 2; i++) {
//            int circularIndex = i % array.length;
//
//            while (stack.size() > 0 && array[stack.peek()] < array[circularIndex]) {
//                int top = stack.pop();
//                result[top] = array[circularIndex];
//            }
//
//            stack.push(circularIndex);
//        }
//
//        return result;
//    }

    //O(n) time | O(n) space - where n = length of array
    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = array.length * 2 - 1; i >= 0; i--) {
            int circularIndex = i % array.length;

            while (stack.size() > 0) {
                if (stack.peek() <= array[circularIndex]) {
                    stack.pop();
                } else {
                    result[circularIndex] = stack.peek();
                    break;
                }
            }

            stack.push(array[circularIndex]);
        }

        return result;
    }
}

/*
Test Cases
Test Case 1
    {
    "array": [2, 5, -3, -4, 6, 7, 2]
    }
    Test Case 2
    {
    "array": [0, 1, 2, 3, 4]
    }
    Test Case 3
    {
    "array": [6, 4, 5, 7, 2, 1, 3]
    }
    Test Case 4
    {
    "array": [1, 0, 1, 0, 1, 0, 1]
    }
    Test Case 5
    {
    "array": [5, 6, 1, 3, 1, -2, -1, 3, 4, 5]
    }
    Test Case 6
    {
    "array": [7, 6, 5, 4, 3, 2, 1]
    }
    Test Case 7
    {
    "array": [5, 6, 1, 2, 3, 4]
    }
    Test Case 8
    {
    "array": [1, 1, 1, 1, 1, 1, 1, 1]
    }
    Test Case 9
    {
    "array": [12]
    }
    Test Case 10
    {
    "array": [12, 4]
    }
    Test Case 11
    {
    "array": [-9, 0, -5, 1, 3, -2, 18, 2, 5, 18]
    }
    Test Case 12
    {
    "array": [2, 6, 7, 2, 2, 2]
    }
    Test Case 13
    {
    "array": [1, 2, 3, 4, 1, 2, 3, 4, -8, -7, 6, 2, 17, 2, -8, 9, 0, 2]
    }
    Test Case 14
    {
    "array": [-8, -1, -1, -2, -4, -5, -6, 0, -9, -91, -2, 8]
    }
    Test Case 15
    {
    "array": []
    }
*/

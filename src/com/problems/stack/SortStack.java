package com.problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortStack {
    public static void main(String[] args) {
        System.out.println(sortStack(new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1))));
    }

    // O(n^2) time | O(n) space - where n is the length of the stack
    public static List<Integer> sortStack(List<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }

        int top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedOrder(stack, top);

        return stack;
    }

    private static void insertInSortedOrder(List<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }

        int top = stack.remove(stack.size() - 1);

        insertInSortedOrder(stack, value);

        stack.add(top);
    }
}

package com.problems.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedBrackets("([])(){}(())()()"));
    }

    //O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";

        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');

        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if (closingBrackets.indexOf(letter) != -1) {
                if (stack.size() == 0) {
                    return false;
                }

                if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}

/*
Test Cases

Test Case 1
    {
    "string": "([])(){}(())()()"
    }
    Test Case 2
    {
    "string": "()[]{}{"
    }
    Test Case 3
    {
    "string": "(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"
    }
    Test Case 4
    {
    "string": "()()[{()})]"
    }
    Test Case 5
    {
    "string": "(()())((()()()))"
    }
    Test Case 6
    {
    "string": "{}()"
    }
    Test Case 7
    {
    "string": "()([])"
    }
    Test Case 8
    {
    "string": "((){{{{[]}}}})"
    }
    Test Case 9
    {
    "string": "((({})()))"
    }
    Test Case 10
    {
    "string": "(([]()()){})"
    }
    Test Case 11
    {
    "string": "(((((([[[[[[{{{{{{{{{{{{()}}}}}}}}}}}}]]]]]]))))))((([])({})[])[])[]([]){}(())"
    }
    Test Case 12
    {
    "string": "{[[[[({(}))]]]]}"
    }
    Test Case 13
    {
    "string": "[((([])([]){}){}){}([])[]((())"
    }
    Test Case 14
    {
    "string": ")[]}"
    }
    Test Case 15
    {
    "string": "(a)"
    }
    Test Case 16
    {
    "string": "(a("
    }
    Test Case 17
    {
    "string": "(141[])(){waga}((51afaw))()hh()"
    }
    Test Case 18
    {
    "string": "aafwgaga()[]a{}{gggg"
    }
    Test Case 19
    {
    "string": "(((((({{{{{safaf[[[[[([)]safsafsa)]]]]]}}}gawga}}))))))"
    }
    Test Case 20
    {
    "string": "()(agawg)[{()gawggaw})]"
    }
    Test Case 21
    {
    "string": "(()agwg())((()agwga()())gawgwgag)"
    }
    Test Case 22
    {
    "string": "{}gawgw()"
    }
    Test Case 23
    {
    "string": "(agwgg)([ghhheah%&@Q])"
    }
*/

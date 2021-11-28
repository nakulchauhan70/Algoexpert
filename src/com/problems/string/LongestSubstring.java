package com.problems.string;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestBalancedSubstring("(()))("));
        System.out.println(longestBalancedSubstring("())()(()())"));
    }

    //Brute force
    //O(n^3) time | O(n) space - where n is the length of input string
//    static public int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//
//        for (int i = 0; i < string.length(); i++) {
//            for (int j = i + 2; j < string.length() + 1; j = j + 2) {
//                if (isBalanced(string.substring(i, j))) {
//                    int currentLength = j - i;
//                    maxLength = Math.max(currentLength, maxLength);
//                }
//            }
//        }
//        return maxLength;
//    }
//
//    private static boolean isBalanced(String string) {
//        Stack<Character> openParanthStack = new Stack<>();
//
//        for (int i = 0; i < string.length(); i++) {
//            char ch = string.charAt(i);
//
//            if (ch == '(') {
//                openParanthStack.push(ch);
//            } else if (openParanthStack.size() > 0) {
//                openParanthStack.pop();
//            } else {
//                return false;
//            }
//        }
//        return openParanthStack.size() == 0;
//    }

    //Using Stack
    //O(n) time | O(n) space
//    static public int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.add(-1);
//
//        for (int i = 0; i < string.length(); i++) {
//            char ch = string.charAt(i);
//            if (ch == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.size() == 0) {
//                    stack.add(i);
//                } else {
//                    int topIndex = stack.get(stack.size() - 1);
//                    int currentLength = i - topIndex;
//                    maxLength = Math.max(currentLength, maxLength);
//                }
//            }
//        }
//
//        return maxLength;
//    }

//    //O(n) time | O(1) space
//    // "((())("
//    private static int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//
//        int openingCount = 0;
//        int closingCount = 0;
//
//        for (int i = 0; i < string.length(); i++) {
//            char ch = string.charAt(i);
//
//            if (ch == '(') {
//                openingCount += 1;
//            } else {
//                closingCount += 1;
//            }
//
//            if (openingCount == closingCount) {
//                maxLength = Math.max(maxLength, closingCount * 2);
//            } else if (closingCount > openingCount) {
//                openingCount = 0;
//                closingCount = 0;
//            }
//        }
//
//        openingCount = 0;
//        closingCount = 0;
//
//        for (int i = string.length() - 1; i > 0; i--) {
//            char ch = string.charAt(i);
//            if (ch == '(') {
//                openingCount += 1;
//            } else {
//                closingCount += 1;
//            }
//
//            if (openingCount == closingCount) {
//                maxLength = Math.max(maxLength, closingCount * 2);
//            } else if (closingCount > openingCount) {
//                openingCount = 0;
//                closingCount = 0;
//            }
//        }
//
//        return maxLength;
//    }


    //O(n) time | O(1) space - More clearer code for 3rd approach
    // "((())("
    private static int longestBalancedSubstring(String string) {
        return Math.max(getLongestBalancedInDirection(string, true), getLongestBalancedInDirection(string, false));
    }

    private static int getLongestBalancedInDirection(String string, boolean leftToRight) {
        char openingParens = leftToRight ? '(' : ')';
        int startIndex = leftToRight ? 0 : string.length() - 1;
        int step = leftToRight ? 1 : -1;

        int maxLength = 0;

        int openingCount = 0;
        int closingCount = 0;

        int index = startIndex;

        while (index >= 0 && index < string.length()) {
            char ch = string.charAt(index);

            if (ch == openingParens) {
                openingCount += 1;
            } else {
                closingCount += 1;
            }

            if (openingCount == closingCount) {
                maxLength = Math.max(maxLength, closingCount * 2);
            } else if (closingCount > openingCount) {
                openingCount = 0;
                closingCount = 0;
            }

            index += step;
        }

        return maxLength;
    }
}

/*
Test Cases

Test Case 1
    {
    "string": "(()))("
    }
    Test Case 2
    {
    "string": "())()(()())"
    }
    Test Case 3
    {
    "string": "()()()()()()()()()()"
    }
    Test Case 4
    {
    "string": "((()))()()()()()()()()()()"
    }
    Test Case 5
    {
    "string": "()"
    }
    Test Case 6
    {
    "string": "(())"
    }
    Test Case 7
    {
    "string": "((((((((()))))))))"
    }
    Test Case 8
    {
    "string": "((((((((((((((((()))))))))))))))))"
    }
    Test Case 9
    {
    "string": "(((()))()())))(()()()())()()"
    }
    Test Case 10
    {
    "string": "((((((()()()())()))((())))()"
    }
    Test Case 11
    {
    "string": "(("
    }
    Test Case 12
    {
    "string": "))"
    }
    Test Case 13
    {
    "string": "("
    }
    Test Case 14
    {
    "string": ")"
    }
    Test Case 15
    {
    "string": "(((((((((((((((((("
    }
    Test Case 16
    {
    "string": "))))))))))))))))))"
    }
    Test Case 17
    {
    "string": "(((((((((((((((((()"
    }
    Test Case 18
    {
    "string": "()))))))))))))))))))"
    }
    Test Case 19
    {
    "string": ")("
    }
    Test Case 20
    {
    "string": "(((((((((())))))))))"
    }
    Test Case 21
    {
    "string": "(((((((((()())))))))))"
    }
    Test Case 22
    {
    "string": "(((((((((()))))))))))"
    }
    Test Case 23
    {
    "string": "))))))))))(((((((((("
    }
    Test Case 24
    {
    "string": ""
    }
    Test Case 25
    {
    "string": "())()"
    }
    Test Case 26
    {
    "string": "()(()"
    }
    Test Case 27
    {
    "string": ")))))))()))))())(((("
    }
    Test Case 28
    {
    "string": "))())(())((())(())(("
    }
    Test Case 29
    {
    "string": ")())()(()(()())))((("
    }
    Test Case 30
    {
    "string": "((()))())()()()()))("
    }
    Test Case 31
    {
    "string": ")(())))(())()))))))("
    }
    Test Case 32
    {
    "string": "()()((((()()))()()()"
    }
    Test Case 33
    {
    "string": "()(())()(()()))((())"
    }
    Test Case 34
    {
    "string": ")(()((()()(()()()((("
    }
    Test Case 35
    {
    "string": ")())()(()))()((()))("
    }
    Test Case 36
    {
    "string": "()()))))(())((()(()("
    }
    Test Case 37
    {
    "string": "(()())())()((())())("
    }
    Test Case 38
    {
    "string": "(()))((())()))))))()"
    }
    Test Case 39
    {
    "string": "(((()()()(())((()()("
    }
    Test Case 40
    {
    "string": ")(()())((()(()())((("
    }
    Test Case 41
    {
    "string": "))()(()()()(()()()))"
    }
    Test Case 42
    {
    "string": "(((((((((((((()(()()"
    }
    Test Case 43
    {
    "string": ")))(()(()(()()()((()"
    }
    Test Case 44
    {
    "string": "()(()((()((()(((((()"
    }
    Test Case 45
    {
    "string": ")((())(((()(()()(())"
    }
    Test Case 46
    {
    "string": ")((((((()))(()))()(("
    }
    Test Case 47
    {
    "string": "()(()()(()(()))((())"
    }
    Test Case 48
    {
    "string": ")))((())()()))())(()"
    }
    Test Case 49
    {
    "string": "()())()((()()(((()))"
    }
    Test Case 50
    {
    "string": ")(()))))(()())))(()("
    }
    Test Case 51
    {
    "string": "))(()()((()))()))()("
    }
    Test Case 52
    {
    "string": ")()()))()(())))))))("
    }
    Test Case 53
    {
    "string": "(((())(())()())()()("
    }
    Test Case 54
    {
    "string": "()()(()()())((((()))"
    }
    Test Case 55
    {
    "string": "((()()((()(((()))())"
    }
    Test Case 56
    {
    "string": "))(())()())())))()))"
    }
    Test Case 57
    {
    "string": "(()(()()())())()((()"
    }
    Test Case 58
    {
    "string": "()()())))()()()())()"
    }
    Test Case 59
    {
    "string": "))((((()))()))()))))"
    }
    Test Case 60
    {
    "string": ")())(())((((((()((()"
    }
    Test Case 61
    {
    "string": ")((()())))((()((()))"
    }
    Test Case 62
    {
    "string": "())(())))(((()()((()"
    }
    Test Case 63
    {
    "string": ")()))((()))(((((((()"
    }
    Test Case 64
    {
    "string": ")((((((((()())((())("
    }
    Test Case 65
    {
    "string": ")(())))((()()()(((()"
    }
    Test Case 66
    {
    "string": ")()()))((((())))((()"
    }
    Test Case 67
    {
    "string": "(()(())(()((()))()()"
    }
    Test Case 68
    {
    "string": "(((()(((()()))((())("
    }
    Test Case 69
    {
    "string": ")()()())()))(())()()"
    }
    Test Case 70
    {
    "string": "((()))())(((()((())("
    }
    Test Case 71
    {
    "string": ")((((()()(()))))()))"
    }
    Test Case 72
    {
    "string": "((()(())))))((()))(("
    }
    Test Case 73
    {
    "string": "(()()))())()()(())(("
    }
    Test Case 74
    {
    "string": "(()))((())()()(((((("
    }
    Test Case 75
    {
    "string": "((()(()))(((((())((("
    }
    Test Case 76
    {
    "string": "())))))())(((())((()"
    }
    Test Case 77
    {
    "string": "(()(()"
    }*/

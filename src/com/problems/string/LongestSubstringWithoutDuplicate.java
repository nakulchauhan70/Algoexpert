package com.problems.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {
    public static void main(String[] args) {
//        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
        System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
    }

    //O(n) time | O(min(N, A)) space where A - no of unique letters present in given string
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int startIndex = 0;
        int[] longest = new int[]{0, 1};

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charFreq.containsKey(ch)) {
                startIndex = Math.max(startIndex, charFreq.get(ch) + 1);
            }

            if (longest[1] - longest[0] < i + 1 - startIndex) {
                longest = new int[]{startIndex, i + 1};
            }

            charFreq.put(ch, i);
        }

        return str.substring(longest[0], longest[1]);
    }

}

//Test Cases
/*
Test Case 1
{
"string": "clementisacap"
}
Test Case 2
{
"string": "a"
}
Test Case 3
{
"string": "abc"
}
Test Case 4
{
"string": "abcb"
}
Test Case 5
{
"string": "abcdeabcdefc"
}
Test Case 6
{
"string": "abccdeaabbcddef"
}
Test Case 7
{
"string": "abacacacaaabacaaaeaaafa"
}
Test Case 8
{
"string": "abcdabcef"
}
Test Case 9
{
"string": "abcbde"
}
Test Case 10
{
"string": "clementisanarm"
}*/

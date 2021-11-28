package com.problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MinimumCharactersForWords {
    public static void main(String[] args) {
        for (char c : minimumCharactersForWords(new String[]{"this", "that", "did", "deed", "them!", "a"})) {
            System.out.println(c);
        }
    }

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> maxFreq = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> letterFreq = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                letterFreq.merge(word.charAt(i), 1, Integer::sum);
            }

            for (Map.Entry<Character, Integer> characterIntegerEntry : letterFreq.entrySet()) {
                if (maxFreq.containsKey(characterIntegerEntry.getKey())) {
                    maxFreq.put(characterIntegerEntry.getKey(), Math.max(maxFreq.get(characterIntegerEntry.getKey()), characterIntegerEntry.getValue()));
                } else {
                    maxFreq.put(characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
                }
            }
        }

        List<Character> ch = new ArrayList<>();

        maxFreq.forEach((k, v) -> IntStream.range(0, v).forEach(v1 -> ch.add(k)));

        char[] charr = new char[ch.size()];
        for (int i = 0; i < ch.size(); i++) {
            charr[i] = ch.get(i);
        }

        return charr;
    }
}

//Test Cases
/*
Test Case 1
{
"words": ["this", "that", "did", "deed", "them!", "a"]
}
Test Case 2
{
"words": ["a", "abc", "ab", "boo"]
}
Test Case 3
{
"words": ["a"]
}
Test Case 4
{
"words": ["abc", "ab", "b", "bac", "c"]
}
Test Case 5
{
"words": ["!!!2", "234", "222", "432"]
}
Test Case 6
{
"words": ["this", "that", "they", "them", "their", "there", "time", "is"]
}
Test Case 7
{
"words": ["tim", "is", "great"]
}
Test Case 8
{
"words": ["abc", "bavcc", "aaaa", "cde", "efg", "gead"]
}
Test Case 9
{
"words": ["a", "a", "a"]
}
Test Case 10
{
"words": ["them", "they", "that", "that", "yes", "yo", "no", "boo", "you", "okay", "too"]
}
Test Case 11
{
"words": ["cta", "cat", "tca", "tac", "a", "c", "t"]
}
Test Case 12
{
"words": ["my", "coding", "skills", "are", "great"]
}
Test Case 13
{
"words": []
}
Test Case 14
{
"words": ["168712hn3;nlsdjhahjdksaxa097918@#$RT%T^&*()_"]
}
Test Case 15
{
"words": ["cat", "cAt", "tAc", "Act", "Cat"]
}
Test Case 16
{
"words": ["Abc", "baVcc", "aaaa", "cdeE", "efg", "gead"]
}
Test Case 17
{
"words": ["mississippi", "piper", "icing", "ice", "pickle", "piping", "pie", "pi", "sassy", "serpent", "python", "ascii", "sister", "mister"]
}*/

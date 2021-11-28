package com.problems.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams2(List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")).forEach(System.out::println);
    }

    // O(w * n * log(n) + n * w * log(w)) time | O(wn) space - where w is the number of words and n is the length of the longest word
    public static List<List<String>> groupAnagrams1(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        if (words.size() == 0) {
            return result;
        }

        List<String> sortedWords = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            sortedWords.add(new String(chars));
        }

        List<Integer> indices = IntStream.range(0, words.size()).boxed().sorted(Comparator.comparing(sortedWords::get)).collect(Collectors.toList());

        List<String> currentAnagramGroup = new ArrayList<>();
        String currentAnagram = sortedWords.get(indices.get(0));

        for (Integer index : indices) {
            String word = words.get(index);
            String sortedWord = sortedWords.get(index);

            if (sortedWord.equals(currentAnagram)) {
                currentAnagramGroup.add(word);
                continue;
            }

            result.add(currentAnagramGroup);
            currentAnagramGroup = new ArrayList<>(List.of(word));
            currentAnagram = sortedWord;
        }

        result.add(currentAnagramGroup);

        return result;
    }

    // O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word
    public static List<List<String>> groupAnagrams2(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<>(List.of(word)));
            }
        }

        return new ArrayList<>(anagrams.values());
    }
}

//Test Cases
/*
Test Case 1
{
"words": ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
}
Test Case 2
{
"words": []
}
Test Case 3
{
"words": ["test"]
}
Test Case 4
{
"words": ["abc", "dabd", "bca", "cab", "ddba"]
}
Test Case 5
{
"words": ["abc", "cba", "bca"]
}
Test Case 6
{
"words": ["zxc", "asd", "weq", "sda", "qwe", "xcz"]
}
Test Case 7
{
"words": ["cinema", "a", "flop", "iceman", "meacyne", "lofp", "olfp"]
}
Test Case 8
{
"words": ["abc", "abe", "abf", "abg"]
}
Test Case 9
{
"words": ["aaa", "a"]
}
Test Case 10
{
"words": ["bob", "boo"]
}
Test Case 11
{
"words": ["ill", "duh"]
}
Test Case 12
{
"words": ["yo", "oy", "zn"]
}
Test Case 13
{
"words": ["yyo", "yo"]
}
Test Case 14
{
"words": ["aca", "bba"]
}*/

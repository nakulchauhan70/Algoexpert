package com.problems.recursion;

import java.util.*;

public class PhoneNumberMnemonics {
    static Map<String, List<String>> digitLetters = new HashMap<>();

    public static void main(String[] args) {
        phoneNumberMnemonics("1905").forEach(System.out::println);
    }

    //O(4^n*n) time | O(4^n*n) space - where n = length of phone no
    public static List<String> phoneNumberMnemonics(String phoneNumber) {
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        List<String> mnemonicsFound = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
        return mnemonicsFound;
    }

    private static void phoneNumberMnemonicsHelper(int index, String phoneNumber, String[] currentMnemonic, List<String> mnemonicsFound) {
        if (index == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic); //O(n) time
            mnemonicsFound.add(mnemonic);
        } else {
            String digit = String.valueOf(phoneNumber.charAt(index));
            List<String> letters = digitLetters.get(digit);
            for (String letter : letters) {
                currentMnemonic[index] = letter;
                phoneNumberMnemonicsHelper(index + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }

        }
    }

    static {
        digitLetters.put("0", List.of("0"));
        digitLetters.put("1", List.of("1"));
        digitLetters.put("2", List.of("a", "b", "c"));
        digitLetters.put("3", List.of("d", "e", "f"));
        digitLetters.put("4", List.of("g", "h", "i"));
        digitLetters.put("5", List.of("j", "k", "l"));
        digitLetters.put("6", List.of("m", "n", "o"));
        digitLetters.put("7", List.of("p", "q", "r", "s"));
        digitLetters.put("8", List.of("t", "u", "v"));
        digitLetters.put("9", List.of("w", "x", "y", "z"));
    }
}

/*
Test Cases
Test Case 1
    {
    "phoneNumber": "1905"
    }
    Test Case 2
    {
    "phoneNumber": "1111"
    }
    Test Case 3
    {
    "phoneNumber": "002"
    }
    Test Case 4
    {
    "phoneNumber": "444"
    }
    Test Case 5
    {
    "phoneNumber": "9056661234"
    }
    Test Case 6
    {
    "phoneNumber": "4163420000"
    }
    Test Case 7
    {
    "phoneNumber": "1"
    }
    Test Case 8
    {
    "phoneNumber": "0"
    }
    Test Case 9
    {
    "phoneNumber": "23"
    }
    Test Case 10
    {
    "phoneNumber": "1212"
    }
    Test Case 11
    {
    "phoneNumber": "97"
    }
    Test Case 12
    {
    "phoneNumber": "980016"
    }
*/

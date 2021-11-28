package com.problems.array;

import java.util.List;
import java.util.Objects;

public class ValidateSubSequence {
    public static void main(String[] args) {

    }

    // O(n) time | O(1) space
    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (Objects.equals(array.get(arrIdx), sequence.get(seqIdx)))
                seqIdx++;
            arrIdx++;
        }

        return seqIdx == sequence.size();
    }

    // O(n) time | O(1) space
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;

        for (Integer value : array) {
            if (seqIdx == sequence.size()) {
                break;
            }

            if (sequence.get(seqIdx).equals(value)) {
                seqIdx++;
            }
        }

        return seqIdx == sequence.size();
    }
}

//Test Cases
/*Test Case 1
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, -1, 10]
}
Test Case 2
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 25, 6, -1, 8, 10]
}
Test Case 3
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 6, -1, 8, 10]
}
Test Case 4
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [22, 25, 6]
}
Test Case 5
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, 10]
}
Test Case 6
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 10]
}
Test Case 7
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, -1, 8, 10]
}
Test Case 8
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [25]
}
Test Case 9
{
"array": [1, 1, 1, 1, 1],
"sequence": [1, 1, 1]
}
Test Case 10
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 25, 6, -1, 8, 10, 12]
}
Test Case 11
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [4, 5, 1, 22, 25, 6, -1, 8, 10]
}
Test Case 12
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 23, 6, -1, 8, 10]
}
Test Case 13
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 22, 25, 6, -1, 8, 10]
}
Test Case 14
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 22, 6, -1, 8, 10]
}
Test Case 15
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, -1, -1]
}
Test Case 16
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, -1, -1, 10]
}
Test Case 17
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, -1, -2]
}
Test Case 18
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [26]
}
Test Case 19
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 25, 22, 6, -1, 8, 10]
}
Test Case 20
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 26, 22, 8]
}
Test Case 21
{
"array": [1, 1, 6, 1],
"sequence": [1, 1, 1, 6]
}
Test Case 22
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [1, 6, -1, 10, 11, 11, 11, 11]
}
Test Case 23
{
"array": [5, 1, 22, 25, 6, -1, 8, 10],
"sequence": [5, 1, 22, 25, 6, -1, 8, 10, 10]
}*/

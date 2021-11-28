package com.problems.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }

    //Best & Average - O(nlogn) time | O(logn) space
    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int pivotIndex = startIndex;
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;

        while (rightIndex >= leftIndex) {
            if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) {
                swap(array, leftIndex, rightIndex);
            } else if (array[leftIndex] <= array[pivotIndex]) {
                leftIndex++;
            } else if (array[rightIndex] >= array[pivotIndex]) {
                rightIndex--;
            }
        }

        swap(array, pivotIndex, rightIndex);

        boolean isLeftSubArraySmaller = ((rightIndex - 1) - startIndex) < (endIndex - (rightIndex + 1));

        if (isLeftSubArraySmaller) {
            quickSortHelper(array, startIndex, rightIndex - 1);
            quickSortHelper(array, rightIndex + 1, endIndex);
        } else {
            quickSortHelper(array, rightIndex + 1, endIndex);
            quickSortHelper(array, startIndex, rightIndex - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*

Test Cases
    Test Case 1
    {
    "array": [8, 5, 2, 9, 5, 6, 3]
    }
    Test Case 2
    {
    "array": [1]
    }
    Test Case 3
    {
    "array": [1, 2]
    }
    Test Case 4
    {
    "array": [2, 1]
    }
    Test Case 5
    {
    "array": [1, 3, 2]
    }
    Test Case 6
    {
    "array": [3, 1, 2]
    }
    Test Case 7
    {
    "array": [1, 2, 3]
    }
    Test Case 8
    {
    "array": [-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8]
    }
    Test Case 9
    {
    "array": [-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8]
    }
    Test Case 10
    {
    "array": [8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4]
    }
    Test Case 11
    {
    "array": [5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1]
    }
    Test Case 12
    {
    "array": [2, -2, -6, -10, 10, 4, -8, -1, -8, -4, 7, -4, 0, 9, -9, 0, -9, -9, 8, 1, -4, 4, 8, 5, 1, 5, 0, 0, 2, -10]
    }
    Test Case 13
    {
    "array": [4, 1, 5, 0, -9, -3, -3, 9, 3, -4, -9, 8, 1, -3, -7, -4, -9, -1, -7, -2, -7, 4]
    }
    Test Case 14
    {
    "array": [427, 787, 222, 996, -359, -614, 246, 230, 107, -706, 568, 9, -246, 12, -764, -212, -484, 603, 934, -848, -646, -991, 661, -32, -348, -474, -439, -56, 507, 736, 635, -171, -215, 564, -710, 710, 565, 892, 970, -755, 55, 821, -3, -153, 240, -160, -610, -583, -27, 131]
    }
    Test Case 15
    {
    "array": [991, -731, -882, 100, 280, -43, 432, 771, -581, 180, -382, -998, 847, 80, -220, 680, 769, -75, -817, 366, 956, 749, 471, 228, -435, -269, 652, -331, -387, -657, -255, 382, -216, -6, -163, -681, 980, 913, -169, 972, -523, 354, 747, 805, 382, -827, -796, 372, 753, 519, 906]
    }
    Test Case 16
    {
    "array": [384, -67, 120, 759, 697, 232, -7, -557, -772, -987, 687, 397, -763, -86, -491, 947, 921, 421, 825, -679, 946, -562, -626, -898, 204, 776, -343, 393, 51, -796, -425, 31, 165, 975, -720, 878, -785, -367, -609, 662, -79, -112, -313, -94, 187, 260, 43, 85, -746, 612, 67, -389, 508, 777, 624, 993, -581, 34, 444, -544, 243, -995, 432, -755, -978, 515, -68, -559, 489, 732, -19, -489, 737, 924]
    }
    Test Case 17
    {
    "array": [544, -578, 556, 713, -655, -359, -810, -731, 194, -531, -685, 689, -279, -738, 886, -54, -320, -500, 738, 445, -401, 993, -753, 329, -396, -924, -975, 376, 748, -356, 972, 459, 399, 669, -488, 568, -702, 551, 763, -90, -249, -45, 452, -917, 394, 195, -877, 153, 153, 788, 844, 867, 266, -739, 904, -154, -947, 464, 343, -312, 150, -656, 528, 61, 94, -581]
    }
    Test Case 18
    {
    "array": [-19, 759, 168, 306, 270, -602, 558, -821, -599, 328, 753, -50, -568, 268, -92, 381, -96, 730, 629, 678, -837, 351, 896, 63, -85, 437, -453, -991, 294, -384, -628, -529, 518, 613, -319, -519, -220, -67, 834, 619, 802, 207, 946, -904, 295, 718, -740, -557, -560, 80, 296, -90, 401, 407, 798, 254, 154, 387, 434, 491, 228, 307, 268, 505, -415, -976, 676, -917, 937, -609, 593, -36, 881, 607, 121, -373, 915, -885, 879, 391, -158, 588, -641, -937, 986, 949, -321]
    }
    Test Case 19
    {
    "array": [-823, 164, 48, -987, 323, 399, -293, 183, -908, -376, 14, 980, 965, 842, 422, 829, 59, 724, -415, -733, 356, -855, -155, 52, 328, -544, -371, -160, -942, -51, 700, -363, -353, -359, 238, 892, -730, -575, 892, 490, 490, 995, 572, 888, -935, 919, -191, 646, -120, 125, -817, 341, -575, 372, -874, 243, 610, -36, -685, -337, -13, 295, 800, -950, -949, -257, 631, -542, 201, -796, 157, 950, 540, -846, -265, 746, 355, -578, -441, -254, -941, -738, -469, -167, -420, -126, -410, 59]
    }
 */

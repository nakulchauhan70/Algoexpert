package com.problems.array;

import java.util.Arrays;

public class WaterStreams {
    public static void main(String[] args) {
        double[][] array = new double[][]{
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        };

        System.out.println(Arrays.toString(waterfallStreams(array, 3)));
    }

    //O(w^2*h) time | O(w) space - where w - width, h- height of array
    public static double[] waterfallStreams(double[][] array, int source) {
        double[] rowAbove = array[0];

        // Using -1 to represent water, as 1 is used in question to represent block
        rowAbove[source] = -1;

        for (int row = 1; row < array.length; row++) {
            double[] currentRow = array[row];

            for (int i = 0; i < rowAbove.length; i++) {
                double valueAbove = rowAbove[i];

                boolean hasWaterAbove = valueAbove < 0;
                boolean hasBlockCurrent = currentRow[i] == 1.0;

                if (!hasWaterAbove) {
                    continue;
                }

                if (!hasBlockCurrent) {
                    currentRow[i] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove / 2;

                //Move water right and left if above is water and current has block

                //Move water left
                int leftIndex = i;
                while (leftIndex - 1 >= 0) {
                    leftIndex--;
                    if (rowAbove[leftIndex] == 1.0) {
                        break;
                    }

                    if (currentRow[leftIndex] != 1.0) {
                        currentRow[leftIndex] += splitWater;
                        break;
                    }
                }

                //Move water right
                int rightIndex = i;
                while (rightIndex + 1 < rowAbove.length) {
                    rightIndex++;
                    if (rowAbove[rightIndex] == 1.0) {
                        break;
                    }

                    if (currentRow[rightIndex] != 1.0) {
                        currentRow[rightIndex] += splitWater;
                        break;
                    }
                }
            }

            rowAbove = currentRow;
        }


        double[] finalPercentage = new double[rowAbove.length];

        for (int i = 0; i < rowAbove.length; i++) {
            double num = rowAbove[i];
            if (num == 0) {
                finalPercentage[i] = num;
            } else {
                finalPercentage[i] = num * (-100);
            }
        }

        return finalPercentage;
    }
}
/*

Test Cases
Test Case 1
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0],
    [1, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 3
    }
    Test Case 2
    {
    "array": [
    [0],
    [0],
    [0],
    [0],
    [0],
    [0],
    [0]
    ],
    "source": 0
    }
    Test Case 3
    {
    "array": [
    [0],
    [0],
    [0],
    [0],
    [0],
    [1],
    [0]
    ],
    "source": 0
    }
    Test Case 4
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 0],
    [0, 0, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 3
    }
    Test Case 5
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 3
    }
    Test Case 6
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0],
    [1, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 0, 0],
    [0, 0, 1, 0, 0, 0, 1],
    [0, 0, 1, 0, 1, 1, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0, 0],
    [0, 0, 1, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 3
    }
    Test Case 7
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0],
    [1, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 0, 0],
    [0, 0, 1, 0, 0, 0, 1],
    [0, 0, 1, 0, 1, 1, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0, 0],
    [1, 1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 6
    }
    Test Case 8
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 8
    }
    Test Case 9
    {
    "array": [
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ],
    "source": 8
    }
*/

package com.problems.array;

import java.util.HashMap;
import java.util.Map;

public class LineThroughPoints {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};
        System.out.println(lineThroughPoints(input));
    }

    public static int lineThroughPoints(int[][] points) {
        int maxPointsOnLine = 1;

        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];

            HashMap<String, Integer> slopes = new HashMap<>();

            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                int[] slopeOfLinesBetweenPoints = getSlopeOfLinesBetweenPoints(p1, p2);
                int rise = slopeOfLinesBetweenPoints[0];
                int run = slopeOfLinesBetweenPoints[1];

                String slopeKey = createHashTableForRational(rise, run);

                if (!slopes.containsKey(slopeKey)) {
                    slopes.put(slopeKey, 1);
                }

                slopes.put(slopeKey, slopes.get(slopeKey) + 1);

                int currentMaxNoOfPointsOnLine = maxSlope(slopes);
                maxPointsOnLine = Math.max(currentMaxNoOfPointsOnLine, maxPointsOnLine);
            }
        }
        return maxPointsOnLine;
    }

    private static int maxSlope(HashMap<String, Integer> slopes) {
        int maxSlope = 0;

        for (Map.Entry<String, Integer> slope : slopes.entrySet()) {
            maxSlope = Math.max(slope.getValue(), maxSlope);
        }

        return maxSlope;
    }

    private static String createHashTableForRational(int rise, int run) {
        return rise + ":" + run;
    }

    private static int[] getSlopeOfLinesBetweenPoints(int[] p1, int[] p2) {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];

        int[] slope = new int[]{1, 0};

        if (x1 != x2) {
            int xDiff = x1 - x2;
            int yDiff = y1 - y2;
            int gcd = getGCD(Math.abs(xDiff), Math.abs(yDiff));
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;

            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }

            slope = new int[]{xDiff, yDiff};
        }

        return slope;
    }

    private static int getGCD(int n1, int n2) {
        int a = n1;
        int b = n2;

        while (true) {
            if (a == 0) {
                return b;
            }

            if (b == 0) {
                return a;
            }

            int temp = a;
            a = b;
            b = temp % b;
        }
    }
}

/*
Test Case 1
    {
    "points": [
    [1, 1],
    [2, 2],
    [3, 3],
    [0, 4],
    [-2, 6],
    [4, 0],
    [2, 1]
    ]
    }
    Test Case 2
    {
    "points": [
    [3, 3],
    [0, 4],
    [-2, 6],
    [4, 0],
    [2, 1],
    [3, 4],
    [5, 6],
    [0, 0]
    ]
    }
    Test Case 3
    {
    "points": [
    [1, 4],
    [3, 5],
    [7, 1],
    [5, 4],
    [4, 5],
    [9, 2],
    [1, 3],
    [2, 8]
    ]
    }
    Test Case 4
    {
    "points": [
    [1, 4],
    [4, 1],
    [3, 3]
    ]
    }
    Test Case 5
    {
    "points": [
    [0, 0]
    ]
    }
    Test Case 6
    {
    "points": [
    [1, 4],
    [4, 1],
    [1, 1],
    [4, 4],
    [2, 3],
    [3, 2],
    [3, 3],
    [2, 2],
    [0, 3]
    ]
    }
    Test Case 7
    {
    "points": [
    [1, 4],
    [4, 1],
    [1, 1],
    [4, 4],
    [2, 3],
    [3, 2],
    [3, 3],
    [2, 2],
    [0, 3],
    [5, 3],
    [3, -1],
    [2, -3],
    [1, -5]
    ]
    }
    Test Case 8
    {
    "points": [
    [-1, -1],
    [-3, -1],
    [-4, -1],
    [1, 1],
    [4, 1]
    ]
    }
    Test Case 9
    {
    "points": [
    [1, 1],
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [2, 1],
    [2, 2],
    [2, 3],
    [2, 4],
    [2, 5],
    [3, 1],
    [3, 2],
    [3, 4],
    [3, 5],
    [4, 1],
    [4, 2],
    [4, 3],
    [4, 4],
    [4, 5],
    [5, 1],
    [5, 2],
    [5, 3],
    [5, 4],
    [5, 5],
    [6, 6],
    [2, 6]
    ]
    }
    Test Case 10
    {
    "points": [
    [1, 1],
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [2, 1],
    [2, 2],
    [2, 4],
    [2, 5],
    [4, 1],
    [4, 2],
    [4, 4],
    [4, 5],
    [5, 1],
    [5, 2],
    [5, 4],
    [5, 5],
    [6, 6],
    [2, 6],
    [-1, -1],
    [0, 0],
    [-2, -2]
    ]
    }
    Test Case 11
    {
    "points": [
    [-78, -9],
    [67, 87],
    [46, 87],
    [4, 5],
    [9, 83],
    [34, 47]
    ]
    }
    Test Case 12
    {
    "points": [
    [1000000001, 1],
    [1, 1],
    [0, 0]
    ]
    }*/

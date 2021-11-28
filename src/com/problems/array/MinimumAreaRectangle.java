package com.problems.array;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        int[][] input =
                new int[][]{
                        {1, 5},
                        {5, 1},
                        {4, 2},
                        {2, 4},
                        {2, 2},
                        {1, 2},
                        {4, 5},
                        {2, 5},
                        {-1, -2}
                };

        System.out.println(minimumAreaRectangle(input));
    }

    //O(n^2) time | O(n) space - where n is the number of points
//    public static int minimumAreaRectangle(int[][] points) {
//        int minimumAreaFound = Integer.MAX_VALUE;
//        HashMap<Integer, int[]> columns = initializeColumns(points);
//        HashMap<String, Integer> edgesParallelToYAxis = new HashMap<>();
//
//        ArrayList<Integer> sortedColumns = new ArrayList<>(columns.keySet());
//        Collections.sort(sortedColumns);
//
//        for (Integer x : sortedColumns) {
//            int[] yValuesInCurrentColumn = columns.get(x);
//            Arrays.sort(yValuesInCurrentColumn);
//
//            for (int i = 0; i < yValuesInCurrentColumn.length; i++) {
//                int y2 = yValuesInCurrentColumn[i];
//                for (int j = 0; j < i; j++) {
//                    int y1 = yValuesInCurrentColumn[j];
//                    String pointString = y1 + ":" + y2;
//
//                    if (edgesParallelToYAxis.containsKey(pointString)) {
//                        int currentArea = (x - edgesParallelToYAxis.get(pointString)) * (y2 - y1);
//                        minimumAreaFound = Math.min(minimumAreaFound, currentArea);
//                    }
//                    edgesParallelToYAxis.put(pointString, x);
//                }
//            }
//        }
//        return minimumAreaFound == Integer.MAX_VALUE ? 0 : minimumAreaFound;
//    }

    //O(n^2) time | O(n) space - where n is the number of points
    public static int minimumAreaRectangle(int[][] points) {
        int minimumAreaFound = Integer.MAX_VALUE;
        HashSet<String> pointSet = createPointSet(points);

        for (int i = 0; i < points.length; i++) {
            int p2x = points[i][0];
            int p2y = points[i][1];

            for (int j = 0; j < i; j++) {
                int p1x = points[j][0];
                int p1y = points[j][1];

                boolean pointShareValue = p1x == p2x || p1y == p2y;

                if (pointShareValue) continue;

                //If (p1x, p2y) and (p2x, p2y), exists we've found a rectangle
                boolean point1OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p1x, p2y));
                boolean point2OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p2x, p1y));
                boolean oppositeDiagonalExists = point1OnOppositeDiagonalExists && point2OnOppositeDiagonalExists;

                if (oppositeDiagonalExists) {
                    int currentArea = Math.abs((p2x - p1x)) * Math.abs(p2y - p1y);
                    minimumAreaFound = Math.min(minimumAreaFound, currentArea);
                }
            }
        }
        return minimumAreaFound == Integer.MAX_VALUE ? 0 : minimumAreaFound;
    }

    private static String convertPointToString(int i, int j) {
        return i + ":" + j;
    }

    private static HashSet<String> createPointSet(int[][] points) {
        HashSet<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            String pointString = convertPointToString(x, y);
            pointSet.add(pointString);
        }
        return pointSet;
    }

    private static HashMap<Integer, int[]> initializeColumns(int[][] points) {
        HashMap<Integer, int[]> columns = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (!columns.containsKey(x)) {
                columns.put(x, new int[]{});
            }

            int[] column = columns.get(x);
            int[] newColumn = new int[column.length + 1];

            for (int i = 0; i < column.length; i++) {
                newColumn[i] = column[i];
            }

            newColumn[column.length] = y;
            columns.put(x, newColumn);
        }
        return columns;
    }
}

/*
Test Cases
Test Case 1
    {
    "points": [
    [1, 5],
    [5, 1],
    [4, 2],
    [2, 4],
    [2, 2],
    [1, 2],
    [4, 5],
    [2, 5],
    [-1, -2]
    ]
    }
    Test Case 2
    {
    "points": [
    [-4, 4],
    [4, 4],
    [4, -2],
    [-4, -2],
    [0, -2],
    [4, 2],
    [0, 2]
    ]
    }
    Test Case 3
    {
    "points": [
    [-4, 4],
    [4, 4],
    [4, -2],
    [-4, -2],
    [0, -2],
    [4, 2],
    [0, 2],
    [0, 4],
    [2, 3],
    [0, 3],
    [2, 4]
    ]
    }
    Test Case 4
    {
    "points": [
    [0, 0],
    [4, 4],
    [8, 8],
    [0, 8]
    ]
    }
    Test Case 5
    {
    "points": [
    [0, 0],
    [4, 4],
    [8, 8],
    [0, 8],
    [0, 4],
    [6, 0],
    [6, 4]
    ]
    }
    Test Case 6
    {
    "points": [
    [0, 0],
    [4, 4],
    [8, 8],
    [0, 8],
    [0, 4],
    [6, 0],
    [6, 4],
    [8, 0],
    [8, 4],
    [6, 2],
    [2, 4],
    [2, 0]
    ]
    }
    Test Case 7
    {
    "points": [
    [0, 0],
    [1, 1],
    [2, 2],
    [-1, -1],
    [-2, -2],
    [-1, 1],
    [-2, 2],
    [1, -1],
    [2, -2]
    ]
    }
    Test Case 8
    {
    "points": [
    [0, 1],
    [0, 0],
    [2, 1],
    [2, 0],
    [4, 0],
    [4, 1],
    [0, 2],
    [2, 2],
    [4, 2],
    [6, 0],
    [6, 1],
    [6, 2],
    [7, 1],
    [7, 0]
    ]
    }
    Test Case 9
    {
    "points": [
    [0, 1],
    [0, 0],
    [2, 1],
    [2, 0],
    [4, 0],
    [4, 1],
    [0, 2],
    [2, 2],
    [4, 2],
    [6, 0],
    [6, 1],
    [6, 2],
    [7, 1]
    ]
    }
    Test Case 10
    {
    "points": [
    [100, 100],
    [76, 67],
    [-100, 100],
    [65, 76],
    [100, -100],
    [3, 4],
    [-100, -100],
    [5, 6],
    [78, 54],
    [-87, 7],
    [1, 4],
    [4, 1],
    [-1, 5]
    ]
    }
    Test Case 11
    {
    "points": []
    }
    Test Case 12
    {
    "points": [
    [1, 2],
    [4, 2]
    ]
    }
    Test Case 13
    {
    "points": [
    [2, 2],
    [3, 2],
    [4, 2]
    ]
    }
*/

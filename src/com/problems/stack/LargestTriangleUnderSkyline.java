package com.problems.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestTriangleUnderSkyline {
    public static void main(String[] args) {
        System.out.println(largestRectangleUnderSkyline(List.of(1, 3, 3, 2, 4, 1, 5, 3, 2)));
    }

    //O(n^2) time | O(1) space
//    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
//        int maxArea = 0;
//
//        for (int pillarIndex = 0; pillarIndex < buildings.size(); pillarIndex++) {
//            int currentHeight = buildings.get(pillarIndex);
//
//            int furthestLeft = pillarIndex;
//            while (furthestLeft > 0 && buildings.get(furthestLeft - 1) >= currentHeight) {
//                furthestLeft--;
//            }
//
//            int furthestRight = pillarIndex;
//            while (furthestRight < buildings.size() - 1 && buildings.get(furthestRight + 1) >= currentHeight) {
//                furthestRight++;
//            }
//
//            int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currentHeight;
//            maxArea = Math.max(areaWithCurrentBuilding, maxArea);
//
//        }
//
//        return maxArea;
//    }

    //O(n) time | O(n) space - where n = no of buildings
    public static int largestRectangleUnderSkyline(List<Integer> buildings) {
        Stack<Integer> pillarIndices = new Stack<>();
        int maxArea = 0;

        ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
        extendedBuildings.add(0);

        for (int i = 0; i < extendedBuildings.size(); i++) {
            int height = extendedBuildings.get(i);
            while (!pillarIndices.isEmpty() && extendedBuildings.get(pillarIndices.peek()) >= height) {
                int pillarHeight = extendedBuildings.get(pillarIndices.pop());
                int width = (pillarIndices.isEmpty()) ? i : i - pillarIndices.peek() - 1;
                maxArea = Math.max(width * pillarHeight, maxArea);
            }

            pillarIndices.push(i);
        }

        return maxArea;
    }
}

/*
Test Cases
Test Case 1
    {
    "buildings": [1, 3, 3, 2, 4, 1, 5, 3, 2]
    }
    Test Case 2
    {
    "buildings": [4, 4, 4, 2, 2, 1]
    }
    Test Case 3
    {
    "buildings": [1, 3, 3, 2, 4, 1, 5, 3]
    }
    Test Case 4
    {
    "buildings": [5, 5, 2, 2, 4, 1]
    }
    Test Case 5
    {
    "buildings": [1, 2, 3, 4, 5, 11]
    }
    Test Case 6
    {
    "buildings": [25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    }
    Test Case 7
    {
    "buildings": [20, 2, 2, 2, 2, 2, 10, 5, 5, 5, 4, 4]
    }
    Test Case 8
    {
    "buildings": [5, 10, 5, 15, 10, 25]
    }
    Test Case 9
    {
    "buildings": [1, 1, 1, 1]
    }
    Test Case 10
    {
    "buildings": [10, 21]
    }
    Test Case 11
    {
    "buildings": [11, 21]
    }
    Test Case 12
    {
    "buildings": [3, 3, 3, 4, 4, 4, 1, 3, 1, 2, 8, 9, 1]
    }
    Test Case 13
    {
    "buildings": [5]
    }
    Test Case 14
    {
    "buildings": [10, 1, 2, 3, 4, 5, 6, 7]
    }
    Test Case 15
    {
    "buildings": [10, 1, 2, 3, 3, 5, 6, 7]
    }
    Test Case 16
    {
    "buildings": []
    }
*/
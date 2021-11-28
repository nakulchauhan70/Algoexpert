package com.problems.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SunsetViews {
    public static void main(String[] args) {
        System.out.println(sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
    }

    // O(n) time | O(n) space - where n is the length of the input array
//    public static List<Integer> sunsetViews(int[] buildings, String direction) {
//        List<Integer> buildingWithSunsetViews = new ArrayList<>();
//
//        int startIndex = buildings.length - 1;
//        int step = -1;
//
//        if (direction.equals("WEST")) {
//            startIndex = 0;
//            step = 1;
//        }
//
//        int index = startIndex;
//        int runningHeight = 0;
//
//        while (index >= 0 && index < buildings.length) {
//            int buildingHeight = buildings[index];
//
//            if (buildingHeight > runningHeight) {
//                buildingWithSunsetViews.add(index);
//            }
//
//            runningHeight = Math.max(runningHeight, buildingHeight);
//
//            index += step;
//        }
//
//        if (direction.equals("EAST")) {
//            Collections.reverse(buildingWithSunsetViews);
//        }
//
//        return buildingWithSunsetViews;
//    }

    // O(n) time | O(n) space - where n is the length of the input array
    public static List<Integer> sunsetViews(int[] buildings, String direction) {
        List<Integer> candidateBuildings = new ArrayList<>();

        int startIndex = buildings.length - 1;
        int step = -1;

        if (direction.equals("EAST")) {
            startIndex = 0;
            step = 1;
        }

        int index = startIndex;

        while (index >= 0 && index < buildings.length) {
            int buildingHeight = buildings[index];

            while (candidateBuildings.size() > 0 && buildings[candidateBuildings.get(candidateBuildings.size() - 1)] <= buildingHeight) {
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(index);

            index += step;

        }

        if (direction.equals("WEST")) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
    }
}

/*Test Cases
Test Case 1
    {
    "buildings": [3, 5, 4, 4, 3, 1, 3, 2],
    "direction": "EAST"
    }
    Test Case 2
    {
    "buildings": [3, 5, 4, 4, 3, 1, 3, 2],
    "direction": "WEST"
    }
    Test Case 3
    {
    "buildings": [10, 11],
    "direction": "EAST"
    }
    Test Case 4
    {
    "buildings": [2, 4],
    "direction": "WEST"
    }
    Test Case 5
    {
    "buildings": [1],
    "direction": "EAST"
    }
    Test Case 6
    {
    "buildings": [1],
    "direction": "WEST"
    }
    Test Case 7
    {
    "buildings": [],
    "direction": "EAST"
    }
    Test Case 8
    {
    "buildings": [],
    "direction": "WEST"
    }
    Test Case 9
    {
    "buildings": [7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5],
    "direction": "EAST"
    }
    Test Case 10
    {
    "buildings": [1, 2, 3, 4, 5, 6],
    "direction": "EAST"
    }
    Test Case 11
    {
    "buildings": [1, 2, 3, 4, 5, 6],
    "direction": "WEST"
    }
    Test Case 12
    {
    "buildings": [1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8],
    "direction": "WEST"
    }
    Test Case 13
    {
    "buildings": [20, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8],
    "direction": "EAST"
    }
*/

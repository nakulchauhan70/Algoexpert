package com.problems.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LowestCommonManager {
    public static void main(String[] args) {
        HashMap<Character, OrgChart> orgCharts = getOrgCharts();
        orgCharts
                .get('A')
                .addDirectReports(new OrgChart[]{orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
                .get('B')
                .addDirectReports(new OrgChart[]{orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
                .get('C')
                .addDirectReports(new OrgChart[]{orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
                .get('D')
                .addDirectReports(new OrgChart[]{orgCharts.get('H'), orgCharts.get('I')});

        System.out.println(getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I')));
    }

    //O(D) time | O(1) space - where D - depth
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    private static OrgInfo getOrgInfo(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;

        for (OrgChart directReport : topManager.directReports) {
            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            numImportantReports += orgInfo.numImportantReports;
        }

        if (topManager == reportOne || topManager == reportTwo) {
            numImportantReports++;
        }

        OrgChart lowestCommonManager = numImportantReports == 2 ? topManager : null;

        return new OrgInfo(lowestCommonManager, numImportantReports);
    }

    public static HashMap<Character, OrgChart> getOrgCharts() {
        var orgCharts = new HashMap<Character, OrgChart>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            orgCharts.put(a, new OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new OrgChart[]{orgCharts.get('Z')});
        return orgCharts;
    }

    static class OrgInfo {
        OrgChart lowestCommonManager;
        int numImportantReports;

        public OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReports = numImportantReports;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}

/*
Test Cases
Test Case 1
    {
    "topManager": "A",
    "reportOne": "E",
    "reportTwo": "I",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C"], "id": "A", "name": "A"},
    {"directReports": ["D", "E"], "id": "B", "name": "B"},
    {"directReports": ["F", "G"], "id": "C", "name": "C"},
    {"directReports": ["H", "I"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": [], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": [], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"}
    ]
    }
    }
    Test Case 2
    {
    "topManager": "A",
    "reportOne": "A",
    "reportTwo": "B",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 3
    {
    "topManager": "A",
    "reportOne": "B",
    "reportTwo": "F",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 4
    {
    "topManager": "A",
    "reportOne": "G",
    "reportTwo": "M",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 5
    {
    "topManager": "A",
    "reportOne": "U",
    "reportTwo": "S",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 6
    {
    "topManager": "A",
    "reportOne": "Z",
    "reportTwo": "M",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 7
    {
    "topManager": "A",
    "reportOne": "O",
    "reportTwo": "I",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 8
    {
    "topManager": "A",
    "reportOne": "T",
    "reportTwo": "Z",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 9
    {
    "topManager": "A",
    "reportOne": "T",
    "reportTwo": "V",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 10
    {
    "topManager": "A",
    "reportOne": "T",
    "reportTwo": "H",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 11
    {
    "topManager": "A",
    "reportOne": "W",
    "reportTwo": "V",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 12
    {
    "topManager": "A",
    "reportOne": "Z",
    "reportTwo": "B",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 13
    {
    "topManager": "A",
    "reportOne": "Q",
    "reportTwo": "W",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
    Test Case 14
    {
    "topManager": "A",
    "reportOne": "A",
    "reportTwo": "Z",
    "orgChart": {
    "nodes": [
    {"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
    {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
    {"directReports": ["J"], "id": "C", "name": "C"},
    {"directReports": ["K", "L"], "id": "D", "name": "D"},
    {"directReports": [], "id": "E", "name": "E"},
    {"directReports": ["M", "N"], "id": "F", "name": "F"},
    {"directReports": [], "id": "G", "name": "G"},
    {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
    {"directReports": [], "id": "I", "name": "I"},
    {"directReports": [], "id": "J", "name": "J"},
    {"directReports": ["S"], "id": "K", "name": "K"},
    {"directReports": [], "id": "L", "name": "L"},
    {"directReports": [], "id": "M", "name": "M"},
    {"directReports": [], "id": "N", "name": "N"},
    {"directReports": [], "id": "O", "name": "O"},
    {"directReports": ["T", "U"], "id": "P", "name": "P"},
    {"directReports": [], "id": "Q", "name": "Q"},
    {"directReports": ["V"], "id": "R", "name": "R"},
    {"directReports": [], "id": "S", "name": "S"},
    {"directReports": [], "id": "T", "name": "T"},
    {"directReports": [], "id": "U", "name": "U"},
    {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
    {"directReports": [], "id": "W", "name": "W"},
    {"directReports": ["Z"], "id": "X", "name": "X"},
    {"directReports": [], "id": "Y", "name": "Y"},
    {"directReports": [], "id": "Z", "name": "Z"}
    ]
    }
    }
*/

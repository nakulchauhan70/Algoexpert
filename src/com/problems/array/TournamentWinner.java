package com.problems.array;

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        System.out.println(tournamentWinner1(List.of(List.of("HTML", "C#"), List.of("C#", "Python"), List.of("Python", "HTML")), List.of(0, 0, 1)));
    }

    public static String tournamentWinner1(List<List<String>> competitions, List<Integer> results) {
        HashMap<String, Integer> resultTeam = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            int winner = results.get(i);
            if (winner == 1) {
                resultTeam.merge(competitions.get(i).get(0), 1, Integer::sum);
            } else {
                resultTeam.merge(competitions.get(i).get(1), 1, Integer::sum);
            }
        }

        Optional<Map.Entry<String, Integer>> entryOptional = resultTeam.entrySet().stream().max(Map.Entry.comparingByValue());

        return entryOptional.map(Map.Entry::getKey).orElse(null);
    }

    //O(n) time | O(k) space - where n - no of competitions, k - no of teams
    public static String tournamentWinner2(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int HOME_TEAM_WON = 1;
        String currentBestTeam = "";
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = new ArrayList<>();
            int result = results.get(i);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;

            updateScores(winningTeam, 3, scores);

            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }

        return currentBestTeam;
    }


    private static void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);
    }
}


//Test Cases
/*
{
"competitions": [
["HTML", "C#"],
["C#", "Python"],
["Python", "HTML"]
],
"results": [0, 0, 1]
}
Test Case 2
{
"competitions": [
["HTML", "Java"],
["Java", "Python"],
["Python", "HTML"]
],
"results": [0, 1, 1]
}
Test Case 3
{
"competitions": [
["HTML", "Java"],
["Java", "Python"],
["Python", "HTML"],
["C#", "Python"],
["Java", "C#"],
["C#", "HTML"]
],
"results": [0, 1, 1, 1, 0, 1]
}
Test Case 4
{
"competitions": [
["HTML", "Java"],
["Java", "Python"],
["Python", "HTML"],
["C#", "Python"],
["Java", "C#"],
["C#", "HTML"],
["SQL", "C#"],
["HTML", "SQL"],
["SQL", "Python"],
["SQL", "Java"]
],
"results": [0, 1, 1, 1, 0, 1, 0, 1, 1, 0]
}
Test Case 5
{
"competitions": [
["Bulls", "Eagles"]
],
"results": [1]
}
Test Case 6
{
"competitions": [
["Bulls", "Eagles"],
["Bulls", "Bears"],
["Bears", "Eagles"]
],
"results": [0, 0, 0]
}
Test Case 7
{
"competitions": [
["Bulls", "Eagles"],
["Bulls", "Bears"],
["Bulls", "Monkeys"],
["Eagles", "Bears"],
["Eagles", "Monkeys"],
["Bears", "Monkeys"]
],
"results": [1, 1, 1, 1, 1, 1]
}
Test Case 8
{
"competitions": [
["AlgoMasters", "FrontPage Freebirds"],
["Runtime Terror", "Static Startup"],
["WeC#", "Hypertext Assassins"],
["AlgoMasters", "WeC#"],
["Static Startup", "Hypertext Assassins"],
["Runtime Terror", "FrontPage Freebirds"],
["AlgoMasters", "Runtime Terror"],
["Hypertext Assassins", "FrontPage Freebirds"],
["Static Startup", "WeC#"],
["AlgoMasters", "Static Startup"],
["FrontPage Freebirds", "WeC#"],
["Hypertext Assassins", "Runtime Terror"],
["AlgoMasters", "Hypertext Assassins"],
["WeC#", "Runtime Terror"],
["FrontPage Freebirds", "Static Startup"]
],
"results": [1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0]
}
Test Case 9
{
"competitions": [
["HTML", "Java"],
["Java", "Python"],
["Python", "HTML"],
["C#", "Python"],
["Java", "C#"],
["C#", "HTML"],
["SQL", "C#"],
["HTML", "SQL"],
["SQL", "Python"],
["SQL", "Java"]
],
"results": [0, 0, 0, 0, 0, 0, 1, 0, 1, 1]
}
Test Case 10
{
"competitions": [
["A", "B"]
],
"results": [0]
}*/

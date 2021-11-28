package com.problems.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");

        System.out.println(graph.depthFirstSearch(new ArrayList<>()));
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        //O(v + e) time | O(v) space
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);

            for (Node child : this.children) {
                child.depthFirstSearch(array);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}


//Test Cases
/*
Test Case 1
{
    "graph": {
        "nodes": [
            {"children": ["B", "C", "D"], "id": "A", "value": "A"},
            {"children": ["E", "F"], "id": "B", "value": "B"},
            {"children": [], "id": "C", "value": "C"},
            {"children": ["G", "H"], "id": "D", "value": "D"},
            {"children": [], "id": "E", "value": "E"},
            {"children": ["I", "J"], "id": "F", "value": "F"},
            {"children": ["K"], "id": "G", "value": "G"},
            {"children": [], "id": "H", "value": "H"},
            {"children": [], "id": "I", "value": "I"},
            {"children": [], "id": "J", "value": "J"},
            {"children": [], "id": "K", "value": "K"}
        ],
        "startNode": "A"
    }
}
Test Case 2
{
"graph": {
"nodes": [
{"children": ["B", "C"], "id": "A", "value": "A"},
{"children": ["D"], "id": "B", "value": "B"},
{"children": [], "id": "C", "value": "C"},
{"children": [], "id": "D", "value": "D"}
],
"startNode": "A"
}
}
Test Case 3
{
"graph": {
"nodes": [
{"children": ["B", "C", "D", "E"], "id": "A", "value": "A"},
{"children": [], "id": "B", "value": "B"},
{"children": ["F"], "id": "C", "value": "C"},
{"children": [], "id": "D", "value": "D"},
{"children": [], "id": "E", "value": "E"},
{"children": [], "id": "F", "value": "F"}
],
"startNode": "A"
}
}
Test Case 4
{
"graph": {
"nodes": [
{"children": ["B"], "id": "A", "value": "A"},
{"children": ["C"], "id": "B", "value": "B"},
{"children": ["D", "E"], "id": "C", "value": "C"},
{"children": ["F"], "id": "D", "value": "D"},
{"children": [], "id": "E", "value": "E"},
{"children": [], "id": "F", "value": "F"}
],
"startNode": "A"
}
}
Test Case 5
{
"graph": {
"nodes": [
{"children": ["B", "C", "D", "E", "F"], "id": "A", "value": "A"},
{"children": ["G", "H", "I"], "id": "B", "value": "B"},
{"children": ["J"], "id": "C", "value": "C"},
{"children": ["K", "L"], "id": "D", "value": "D"},
{"children": [], "id": "E", "value": "E"},
{"children": ["M", "N"], "id": "F", "value": "F"},
{"children": [], "id": "G", "value": "G"},
{"children": ["O", "P", "Q", "R"], "id": "H", "value": "H"},
{"children": [], "id": "I", "value": "I"},
{"children": [], "id": "J", "value": "J"},
{"children": ["S"], "id": "K", "value": "K"},
{"children": [], "id": "L", "value": "L"},
{"children": [], "id": "M", "value": "M"},
{"children": [], "id": "N", "value": "N"},
{"children": [], "id": "O", "value": "O"},
{"children": ["T", "U"], "id": "P", "value": "P"},
{"children": [], "id": "Q", "value": "Q"},
{"children": ["V"], "id": "R", "value": "R"},
{"children": [], "id": "S", "value": "S"},
{"children": [], "id": "T", "value": "T"},
{"children": [], "id": "U", "value": "U"},
{"children": ["W", "X", "Y"], "id": "V", "value": "V"},
{"children": [], "id": "W", "value": "W"},
{"children": ["Z"], "id": "X", "value": "X"},
{"children": [], "id": "Y", "value": "Y"},
{"children": [], "id": "Z", "value": "Z"}
],
"startNode": "A"
}
}*/

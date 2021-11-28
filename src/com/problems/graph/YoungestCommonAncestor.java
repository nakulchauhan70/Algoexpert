package com.problems.graph;

import java.util.HashMap;

public class YoungestCommonAncestor {
    public static void main(String[] args) {
        HashMap<Character, AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[]{trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[]{trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[]{trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[]{trees.get('F'), trees.get('G')});

        System.out.println(getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I')));
    }

    //O(D) time | O(1) space - where D - depth
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);

        if (depthOne > depthTwo) {
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
        while (diff > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }

        while (lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }

        return lowerDescendant;
    }

    private static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    public static HashMap<Character, AncestralTree> getTrees() {
        var trees = new HashMap<Character, AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees.get('A').addAsAncestor(
                new AncestralTree[]{
                        trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                });
        return trees;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

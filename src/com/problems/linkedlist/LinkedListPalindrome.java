package com.problems.linkedlist;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        var head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);

        System.out.println(linkedListPalindrome(head));
    }

    //O(n) time | O(n) space - where n = no of nodes in the linked list
//    public static boolean linkedListPalindrome(LinkedList head) {
//        LinkedListInfo isPalindromeResult = isPalindrome(head, head);
//        return isPalindromeResult.outerNodesAreEqual;
//    }

    public static boolean linkedListPalindrome(LinkedList head) {
        LinkedList slowNode = head;
        LinkedList fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
        LinkedList firstHalfNode = head;

        while (reversedSecondHalfNode != null) {
            if (reversedSecondHalfNode.value != firstHalfNode.value) {
                return false;
            }

            reversedSecondHalfNode = reversedSecondHalfNode.next;
            firstHalfNode = firstHalfNode.next;
        }

        return true;
    }

    private static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previousNode = null;
        LinkedList currentNode = head;
        //current - 1,2,3,4, prev - null
        //next - 2,3,4, current.next = null, prev = 1,2,3,4, current = 2,3,4
        //next - 3,4    current.next = 1,2,3,4, prev = 2,3,4, current = 3,4
        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    private static LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
        if (rightNode == null) return new LinkedListInfo(true, leftNode);

        LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
        LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare;
        boolean outerNodeAreEqual = recursiveCallResults.outerNodesAreEqual;

        boolean recursiveIsEqual = outerNodeAreEqual && (leftNodeToCompare.value == rightNode.value);
        LinkedList nextLeftNodeToCompare = leftNodeToCompare.next;

        return new LinkedListInfo(recursiveIsEqual, nextLeftNodeToCompare);
    }

    static class LinkedListInfo {
        boolean outerNodesAreEqual;
        LinkedList leftNodeToCompare;

        public LinkedListInfo(boolean outerNodesAreEqual, LinkedList leftNodeToCompare) {
            this.outerNodesAreEqual = outerNodesAreEqual;
            this.leftNodeToCompare = leftNodeToCompare;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

/*
Test Cases
Test Case 1
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "2-2", "value": 2},
    {"id": "2-2", "next": "1-2", "value": 2},
    {"id": "1-2", "next": "0-2", "value": 1},
    {"id": "0-2", "next": null, "value": 0}
    ]
    }
    }
    Test Case 2
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": null, "value": 0}
    ]
    }
    }
    Test Case 3
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": null, "value": 1}
    ]
    }
    }
    Test Case 4
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "0-2", "value": 0},
    {"id": "0-2", "next": null, "value": 0}
    ]
    }
    }
    Test Case 5
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": null, "value": 3}
    ]
    }
    }
    Test Case 6
    {
    "linkedList": {
    "head": "6",
    "nodes": [
    {"id": "6", "next": "5", "value": 6},
    {"id": "5", "next": "4", "value": 5},
    {"id": "4", "next": "3", "value": 4},
    {"id": "3", "next": "4-2", "value": 3},
    {"id": "4-2", "next": "5-2", "value": 4},
    {"id": "5-2", "next": "6-2", "value": 5},
    {"id": "6-2", "next": null, "value": 6}
    ]
    }
    }
    Test Case 7
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": "4", "value": 3},
    {"id": "4", "next": "5", "value": 4},
    {"id": "5", "next": "5-2", "value": 5},
    {"id": "5-2", "next": "4-2", "value": 5},
    {"id": "4-2", "next": "3-2", "value": 4},
    {"id": "3-2", "next": "2-2", "value": 3},
    {"id": "2-2", "next": "1-2", "value": 2},
    {"id": "1-2", "next": "0-2", "value": 1},
    {"id": "0-2", "next": "12", "value": 0},
    {"id": "12", "next": null, "value": 12}
    ]
    }
    }
    Test Case 8
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": "4", "value": 3},
    {"id": "4", "next": "5", "value": 4},
    {"id": "5", "next": "5-2", "value": 5},
    {"id": "5-2", "next": "4-2", "value": 5},
    {"id": "4-2", "next": "3-2", "value": 4},
    {"id": "3-2", "next": "2-2", "value": 3},
    {"id": "2-2", "next": "1-2", "value": 2},
    {"id": "1-2", "next": "0-2", "value": 1},
    {"id": "0-2", "next": null, "value": 0}
    ]
    }
    }
    Test Case 9
    {
    "linkedList": {
    "head": "10000",
    "nodes": [
    {"id": "10000", "next": "10000-2", "value": 10000},
    {"id": "10000-2", "next": "10000-3", "value": 10000},
    {"id": "10000-3", "next": null, "value": 10000}
    ]
    }
    }
    Test Case 10
    {
    "linkedList": {
    "head": "10000",
    "nodes": [
    {"id": "10000", "next": "10000-2", "value": 10000},
    {"id": "10000-2", "next": "10000-3", "value": 10000},
    {"id": "10000-3", "next": "10000-4", "value": 10000},
    {"id": "10000-4", "next": null, "value": 10000}
    ]
    }
    }
    Test Case 11
    {
    "linkedList": {
    "head": "3",
    "nodes": [
    {"id": "3", "next": "1", "value": 3},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3-2", "value": 2},
    {"id": "3-2", "next": null, "value": 3}
    ]
    }
    }
    Test Case 12
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": "4", "value": 3},
    {"id": "4", "next": "5", "value": 4},
    {"id": "5", "next": "6", "value": 5},
    {"id": "6", "next": "7", "value": 6},
    {"id": "7", "next": "8", "value": 7},
    {"id": "8", "next": "9", "value": 8},
    {"id": "9", "next": "10", "value": 9},
    {"id": "10", "next": "11", "value": 10},
    {"id": "11", "next": "10-2", "value": 11},
    {"id": "10-2", "next": "9-2", "value": 10},
    {"id": "9-2", "next": "8-2", "value": 9},
    {"id": "8-2", "next": "7-2", "value": 8},
    {"id": "7-2", "next": "6-2", "value": 7},
    {"id": "6-2", "next": "5-2", "value": 6},
    {"id": "5-2", "next": "4-2", "value": 5},
    {"id": "4-2", "next": "3-2", "value": 4},
    {"id": "3-2", "next": "2-2", "value": 3},
    {"id": "2-2", "next": "1-2", "value": 2},
    {"id": "1-2", "next": null, "value": 1}
    ]
    }
    }
    Test Case 13
    {
    "linkedList": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "1", "value": 0},
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": "4", "value": 3},
    {"id": "4", "next": "5", "value": 4},
    {"id": "5", "next": "6", "value": 5},
    {"id": "6", "next": "7", "value": 6},
    {"id": "7", "next": "8", "value": 7},
    {"id": "8", "next": "9", "value": 8},
    {"id": "9", "next": "10", "value": 9},
    {"id": "10", "next": "11", "value": 10},
    {"id": "11", "next": "10-2", "value": 11},
    {"id": "10-2", "next": "9-2", "value": 10},
    {"id": "9-2", "next": "8-2", "value": 9},
    {"id": "8-2", "next": "7-2", "value": 8},
    {"id": "7-2", "next": "6-2", "value": 7},
    {"id": "6-2", "next": "5-2", "value": 6},
    {"id": "5-2", "next": "4-2", "value": 5},
    {"id": "4-2", "next": "3-2", "value": 4},
    {"id": "3-2", "next": "2-2", "value": 3},
    {"id": "2-2", "next": "1-2", "value": 2},
    {"id": "1-2", "next": "0-2", "value": 1},
    {"id": "0-2", "next": null, "value": 0}
    ]
    }
    }
    Test Case 14
    {
    "linkedList": {
    "head": "1",
    "nodes": [
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": "1-2", "value": 3},
    {"id": "1-2", "next": "2-2", "value": 1},
    {"id": "2-2", "next": null, "value": 2}
    ]
    }
    }
*/
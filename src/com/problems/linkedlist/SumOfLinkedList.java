package com.problems.linkedlist;

public class SumOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
        linkedListOne.next = new LinkedList(4);
        linkedListOne.next.next = new LinkedList(7);
        linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
        linkedListTwo.next = new LinkedList(4);
        linkedListTwo.next.next = new LinkedList(5);

        LinkedList r = sumOfLinkedLists(linkedListOne, linkedListTwo);
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        return sumOfLinkedListsHelper(linkedListOne, linkedListTwo, 0, null);
    }

    private static LinkedList sumOfLinkedListsHelper(LinkedList head1, LinkedList head2, int carry, LinkedList result) {
        if (head1 == null && head2 == null) {
            return result;
        }

        int value;
        int newCarry;

        if (head1 == null) {
            value = (head2.value + carry) % 10;
            newCarry = (head2.value + carry) / 10;
            if (result != null) {
                result.next = new LinkedList(value);
            } else {
                result = new LinkedList(value);
            }
            head2 = head2.next;
        } else if (head2 == null) {
            value = (head1.value + carry) % 10;
            newCarry = (head1.value + carry) / 10;
            if (result != null) {
                result.next = new LinkedList(value);
            } else {
                result = new LinkedList(value);
            }
            head1 = head1.next;
        } else {
            value = (head1.value + head2.value + carry) % 10;
            newCarry = (head1.value + head2.value + carry) / 10;
            if (result != null) {
                result.next = new LinkedList(value);
            } else {
                result = new LinkedList(value);
            }
            head1 = head1.next;
            head2 = head2.next;
        }


        result.next =  sumOfLinkedListsHelper(head1, head2, newCarry, result.next);

        return result;
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
    "linkedListOne": {
    "head": "2",
    "nodes": [
    {"id": "2", "next": "4", "value": 2},
    {"id": "4", "next": "7", "value": 4},
    {"id": "7", "next": "1", "value": 7},
    {"id": "1", "next": null, "value": 1}
    ]
    },
    "linkedListTwo": {
    "head": "9",
    "nodes": [
    {"id": "9", "next": "4", "value": 9},
    {"id": "4", "next": "5", "value": 4},
    {"id": "5", "next": null, "value": 5}
    ]
    }
    }
    Test Case 2
    {
    "linkedListOne": {
    "head": "2",
    "nodes": [
    {"id": "2", "next": null, "value": 2}
    ]
    },
    "linkedListTwo": {
    "head": "9",
    "nodes": [
    {"id": "9", "next": null, "value": 9}
    ]
    }
    }
    Test Case 3
    {
    "linkedListOne": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "0-2", "value": 0},
    {"id": "0-2", "next": "0-3", "value": 0},
    {"id": "0-3", "next": "5", "value": 0},
    {"id": "5", "next": null, "value": 5}
    ]
    },
    "linkedListTwo": {
    "head": "9",
    "nodes": [
    {"id": "9", "next": null, "value": 9}
    ]
    }
    }
    Test Case 4
    {
    "linkedListOne": {
    "head": "1",
    "nodes": [
    {"id": "1", "next": "1-2", "value": 1},
    {"id": "1-2", "next": "1-3", "value": 1},
    {"id": "1-3", "next": null, "value": 1}
    ]
    },
    "linkedListTwo": {
    "head": "9",
    "nodes": [
    {"id": "9", "next": "9-2", "value": 9},
    {"id": "9-2", "next": "9-3", "value": 9},
    {"id": "9-3", "next": null, "value": 9}
    ]
    }
    }
    Test Case 5
    {
    "linkedListOne": {
    "head": "1",
    "nodes": [
    {"id": "1", "next": "2", "value": 1},
    {"id": "2", "next": "3", "value": 2},
    {"id": "3", "next": null, "value": 3}
    ]
    },
    "linkedListTwo": {
    "head": "6",
    "nodes": [
    {"id": "6", "next": "7", "value": 6},
    {"id": "7", "next": "9", "value": 7},
    {"id": "9", "next": "1", "value": 9},
    {"id": "1", "next": "8", "value": 1},
    {"id": "8", "next": null, "value": 8}
    ]
    }
    }
    Test Case 6
    {
    "linkedListOne": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": null, "value": 0}
    ]
    },
    "linkedListTwo": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": null, "value": 0}
    ]
    }
    }
    Test Case 7
    {
    "linkedListOne": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": null, "value": 0}
    ]
    },
    "linkedListTwo": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "0-2", "value": 0},
    {"id": "0-2", "next": "0-3", "value": 0},
    {"id": "0-3", "next": "0-4", "value": 0},
    {"id": "0-4", "next": "0-5", "value": 0},
    {"id": "0-5", "next": "8", "value": 0},
    {"id": "8", "next": null, "value": 8}
    ]
    }
    }
    Test Case 8
    {
    "linkedListOne": {
    "head": "4",
    "nodes": [
    {"id": "4", "next": "6", "value": 4},
    {"id": "6", "next": "9", "value": 6},
    {"id": "9", "next": "3", "value": 9},
    {"id": "3", "next": "1", "value": 3},
    {"id": "1", "next": null, "value": 1}
    ]
    },
    "linkedListTwo": {
    "head": "0",
    "nodes": [
    {"id": "0", "next": "0-2", "value": 0},
    {"id": "0-2", "next": "0-3", "value": 0},
    {"id": "0-3", "next": "0-4", "value": 0},
    {"id": "0-4", "next": "2", "value": 0},
    {"id": "2", "next": "7", "value": 2},
    {"id": "7", "next": null, "value": 7}
    ]
    }
    }
*/

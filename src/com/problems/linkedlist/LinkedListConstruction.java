package com.problems.linkedlist;

public class LinkedListConstruction {
    public static void main(String[] args) {

    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        //O(1) time | O(1) space
        public void setHead(Node node) {
            if (this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }

            this.insertBefore(this.head, node);
        }

        //O(1) time | O(1) space
        public void setTail(Node node) {
            if (this.tail == null) {
                this.setHead(node);
                return;
            }

            this.insertAfter(this.tail, node);
        }

        //O(1) time | O(1) space
        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == this.head && nodeToInsert == this.tail) {
                return;
            }

            this.remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;

            // Dealing with head
            if (node.prev == null) {
                this.head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }

            node.prev = nodeToInsert;
        }

        //O(1) time | O(1) space
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == this.head && nodeToInsert == this.tail) {
                return;
            }

            this.remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;

            // Dealing with tail
            if (node.next == null) {
                this.tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }

            node.next = nodeToInsert;
        }

        //O(p) time | O(1) space - where p = iterating up to position p
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                this.setHead(nodeToInsert);
                return;
            }

            Node node = this.head;
            int currentPosition = 1;

            while (node != null && currentPosition != position) {
                node = node.next;
                currentPosition++;
            }

            if (node != null) { // we are not at tail, somewhere in middle
                this.insertBefore(node, nodeToInsert);
            } else { //we are at tail
                this.setTail(nodeToInsert);
            }
        }

        //O(n) time | O(1) space
        public void removeNodesWithValue(int value) {
            Node node = head;
            while (node != null) {
                Node nodeToRemove = node;
                node = node.next;   //can't do this after if, because we will lose next and prev node for current node
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }
        }

        //O(n) time | O(1) space
        public boolean containsNodeWithValue(int value) {
            Node node = this.head;
            while (node != null) {
                if (value == node.value)
                    return true;
                node = node.next;
            }
            return false;
        }

        //O(1) time | O(1) space
        public void remove(Node node) {
            //handle edge case of head/tail
            if (node == this.head) {
                this.head = this.head.next;
            }

            if (node == this.tail) {
                this.tail = this.tail.prev;
            }

            this.removeNodeBinding(node);
        }

        private void removeNodeBinding(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

/*
Test Cases
Test Case 1
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "3-2", "next": null, "prev": null, "value": 3},
    {"id": "3-3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4},
    {"id": "5", "next": null, "prev": null, "value": 5},
    {"id": "6", "next": null, "prev": null, "value": 6}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["5"],
    "method": "setHead"
    },
    {
    "arguments": ["4"],
    "method": "setHead"
    },
    {
    "arguments": ["3"],
    "method": "setHead"
    },
    {
    "arguments": ["2"],
    "method": "setHead"
    },
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["4"],
    "method": "setHead"
    },
    {
    "arguments": ["6"],
    "method": "setTail"
    },
    {
    "arguments": ["6", "3"],
    "method": "insertBefore"
    },
    {
    "arguments": ["6", "3-2"],
    "method": "insertAfter"
    },
    {
    "arguments": [1, "3-3"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [3],
    "method": "removeNodesWithValue"
    },
    {
    "arguments": ["2"],
    "method": "remove"
    },
    {
    "arguments": [5],
    "method": "containsNodeWithValue"
    }
    ]
    }
    Test Case 2
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    }
    ]
    }
    Test Case 3
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setTail"
    }
    ]
    }
    Test Case 4
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": [1, "1"],
    "method": "insertAtPosition"
    }
    ]
    }
    Test Case 5
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["2"],
    "method": "setTail"
    }
    ]
    }
    Test Case 6
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["2"],
    "method": "setHead"
    }
    ]
    }
    Test Case 7
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    }
    ]
    }
    Test Case 8
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertBefore"
    }
    ]
    }
    Test Case 9
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    }
    ]
    }
    Test Case 10
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setTail"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertBefore"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertBefore"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertBefore"
    }
    ]
    }
    Test Case 11
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1"],
    "method": "setTail"
    }
    ]
    }
    Test Case 12
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setTail"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertBefore"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertBefore"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertBefore"
    },
    {
    "arguments": ["1"],
    "method": "setHead"
    }
    ]
    }
    Test Case 13
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "1"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertBefore"
    }
    ]
    }
    Test Case 14
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4},
    {"id": "5", "next": null, "prev": null, "value": 5},
    {"id": "6", "next": null, "prev": null, "value": 6},
    {"id": "7", "next": null, "prev": null, "value": 7}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["4", "5"],
    "method": "insertAfter"
    },
    {
    "arguments": ["5", "6"],
    "method": "insertAfter"
    },
    {
    "arguments": ["6", "7"],
    "method": "insertAfter"
    },
    {
    "arguments": [7, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [1, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [2, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [3, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [4, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [5, "1"],
    "method": "insertAtPosition"
    },
    {
    "arguments": [6, "1"],
    "method": "insertAtPosition"
    }
    ]
    }
    Test Case 15
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1"],
    "method": "remove"
    }
    ]
    }
    Test Case 16
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": [1],
    "method": "removeNodesWithValue"
    }
    ]
    }
    Test Case 17
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1"],
    "method": "remove"
    }
    ]
    }
    Test Case 18
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["4"],
    "method": "remove"
    }
    ]
    }
    Test Case 19
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2"],
    "method": "remove"
    }
    ]
    }
    Test Case 20
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "1-2", "next": null, "prev": null, "value": 1},
    {"id": "1-3", "next": null, "prev": null, "value": 1},
    {"id": "1-4", "next": null, "prev": null, "value": 1}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "1-2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1-2", "1-3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1-3", "1-4"],
    "method": "insertAfter"
    },
    {
    "arguments": [1],
    "method": "removeNodesWithValue"
    }
    ]
    }
    Test Case 21
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "1-2", "next": null, "prev": null, "value": 1},
    {"id": "1-3", "next": null, "prev": null, "value": 1},
    {"id": "1-4", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "1-2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1-2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "1-3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["1-3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": [1],
    "method": "removeNodesWithValue"
    }
    ]
    }
    Test Case 22
    {
    "nodes": [
    {"id": "1", "next": null, "prev": null, "value": 1},
    {"id": "2", "next": null, "prev": null, "value": 2},
    {"id": "3", "next": null, "prev": null, "value": 3},
    {"id": "4", "next": null, "prev": null, "value": 4}
    ],
    "classMethodsToCall": [
    {
    "arguments": ["1"],
    "method": "setHead"
    },
    {
    "arguments": ["1", "2"],
    "method": "insertAfter"
    },
    {
    "arguments": ["2", "3"],
    "method": "insertAfter"
    },
    {
    "arguments": ["3", "4"],
    "method": "insertAfter"
    },
    {
    "arguments": [1],
    "method": "containsNodeWithValue"
    },
    {
    "arguments": [2],
    "method": "containsNodeWithValue"
    },
    {
    "arguments": [3],
    "method": "containsNodeWithValue"
    },
    {
    "arguments": [4],
    "method": "containsNodeWithValue"
    },
    {
    "arguments": [5],
    "method": "containsNodeWithValue"
    }
    ]
    }
*/
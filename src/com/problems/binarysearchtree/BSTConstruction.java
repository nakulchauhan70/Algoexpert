package com.problems.binarysearchtree;

//Iterative
public class BSTConstruction {
    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        root.insert(12);

        root.remove(10);

        System.out.println(root.contains(15));
    }

    // BST Property =>
    // Value is strictly greater than value of every node of it's left,
    // it's value is less than equal to the values of every node to it's right,
    // it's children nodes are valid BST or None/null
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        //Average : O(logn) time | O(1) space
        //Worst :  O(n) time | O(1) value
        public BST insert(int value) {
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        //Average : O(logn) time | O(1) space
        //Worst :  O(n) time | O(1) value
        public boolean contains(int value) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }


        //Average : O(logn) time | O(1) space
        //Worst :  O(n) time | O(1) value
        public BST remove(int value) {
            remove(value, null);
            // Do not edit the return statement of this method.
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currentNode = this;

            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            //Single node tree, do nothing
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        private int getMinValue() {
            BST currentNode = this;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }

//        private int getMinValue() {
//            if(left==null) {
//                return value;
//            } else {
//                return left.getMinValue();
//            }
//        }
    }
}

/*
Test Cases
Test Case 1
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [13],
    "method": "insert"
    },
    {
    "arguments": [22],
    "method": "insert"
    },
    {
    "arguments": [1],
    "method": "insert"
    },
    {
    "arguments": [14],
    "method": "insert"
    },
    {
    "arguments": [12],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "contains"
    }
    ]
    }
    Test Case 2
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    }
    ]
    }
    Test Case 3
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "contains"
    },
    {
    "arguments": [5],
    "method": "contains"
    },
    {
    "arguments": [15],
    "method": "contains"
    },
    {
    "arguments": [1],
    "method": "contains"
    },
    {
    "arguments": [6],
    "method": "contains"
    },
    {
    "arguments": [11],
    "method": "contains"
    },
    {
    "arguments": [16],
    "method": "contains"
    }
    ]
    }
    Test Case 4
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "remove"
    },
    {
    "arguments": [10],
    "method": "remove"
    }
    ]
    }
    Test Case 5
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "contains"
    },
    {
    "arguments": [5],
    "method": "contains"
    },
    {
    "arguments": [15],
    "method": "contains"
    },
    {
    "arguments": [10],
    "method": "remove"
    },
    {
    "arguments": [5],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "remove"
    },
    {
    "arguments": [10],
    "method": "contains"
    },
    {
    "arguments": [5],
    "method": "contains"
    },
    {
    "arguments": [15],
    "method": "contains"
    }
    ]
    }
    Test Case 6
    {
    "rootValue": 1,
    "classMethodsToCall": [
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [3],
    "method": "insert"
    },
    {
    "arguments": [4],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [6],
    "method": "insert"
    },
    {
    "arguments": [7],
    "method": "insert"
    },
    {
    "arguments": [8],
    "method": "insert"
    },
    {
    "arguments": [9],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "insert"
    },
    {
    "arguments": [11],
    "method": "insert"
    },
    {
    "arguments": [12],
    "method": "insert"
    },
    {
    "arguments": [13],
    "method": "insert"
    },
    {
    "arguments": [14],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [16],
    "method": "insert"
    },
    {
    "arguments": [17],
    "method": "insert"
    },
    {
    "arguments": [18],
    "method": "insert"
    },
    {
    "arguments": [19],
    "method": "insert"
    },
    {
    "arguments": [20],
    "method": "insert"
    },
    {
    "arguments": [2],
    "method": "remove"
    },
    {
    "arguments": [4],
    "method": "remove"
    },
    {
    "arguments": [6],
    "method": "remove"
    },
    {
    "arguments": [8],
    "method": "remove"
    },
    {
    "arguments": [11],
    "method": "remove"
    },
    {
    "arguments": [13],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "remove"
    },
    {
    "arguments": [17],
    "method": "remove"
    },
    {
    "arguments": [19],
    "method": "remove"
    },
    {
    "arguments": [1],
    "method": "insert"
    },
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [3],
    "method": "insert"
    },
    {
    "arguments": [4],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [6],
    "method": "insert"
    },
    {
    "arguments": [7],
    "method": "insert"
    },
    {
    "arguments": [8],
    "method": "insert"
    },
    {
    "arguments": [9],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "insert"
    },
    {
    "arguments": [9000],
    "method": "contains"
    }
    ]
    }
    Test Case 7
    {
    "rootValue": 1,
    "classMethodsToCall": [
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [3],
    "method": "insert"
    },
    {
    "arguments": [4],
    "method": "insert"
    },
    {
    "arguments": [1],
    "method": "remove"
    }
    ]
    }
    Test Case 8
    {
    "rootValue": 1,
    "classMethodsToCall": [
    {
    "arguments": [-2],
    "method": "insert"
    },
    {
    "arguments": [-3],
    "method": "insert"
    },
    {
    "arguments": [-4],
    "method": "insert"
    },
    {
    "arguments": [1],
    "method": "remove"
    }
    ]
    }
    Test Case 9
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [10],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "contains"
    }
    ]
    }
    Test Case 10
    {
    "rootValue": 10,
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [15],
    "method": "insert"
    },
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "insert"
    },
    {
    "arguments": [13],
    "method": "insert"
    },
    {
    "arguments": [22],
    "method": "insert"
    },
    {
    "arguments": [1],
    "method": "insert"
    },
    {
    "arguments": [14],
    "method": "insert"
    },
    {
    "arguments": [12],
    "method": "insert"
    },
    {
    "arguments": [5],
    "method": "remove"
    },
    {
    "arguments": [5],
    "method": "remove"
    },
    {
    "arguments": [12],
    "method": "remove"
    },
    {
    "arguments": [13],
    "method": "remove"
    },
    {
    "arguments": [14],
    "method": "remove"
    },
    {
    "arguments": [22],
    "method": "remove"
    },
    {
    "arguments": [2],
    "method": "remove"
    },
    {
    "arguments": [1],
    "method": "remove"
    },
    {
    "arguments": [15],
    "method": "contains"
    }
    ]
    }
*/

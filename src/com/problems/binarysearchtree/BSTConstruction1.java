package com.problems.binarysearchtree;

//Recursive
public class BSTConstruction1 {
    public static void main(String[] args) {
        var root = new BSTConstruction.BST(10);
        root.left = new BSTConstruction.BST(5);
        root.left.left = new BSTConstruction.BST(2);
        root.left.left.left = new BSTConstruction.BST(1);
        root.left.right = new BSTConstruction.BST(5);
        root.right = new BSTConstruction.BST(15);
        root.right.left = new BSTConstruction.BST(13);
        root.right.left.right = new BSTConstruction.BST(14);
        root.right.right = new BSTConstruction.BST(22);

        root.insert(12);

        root.remove(10);

        System.out.println(root.contains(15));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        //Average : O(logn) time | O(logn) space
        //Worst :  O(n) time | O(n) value
        public BST insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        //Average : O(logn) time | O(logn) space
        //Worst :  O(n) time | O(n) value
        public boolean contains(int value) {
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    right.contains(value);
                }
            } else {
                return true;
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            // Do not edit the return statement of this method.
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        //Single node tree, do nothing
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
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

package com.problems.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Min Heap property - every node must be less than equal to it's children node
public class MinHeapConstruction {
    public static void main(String[] args) {
        MinHeap minHeap =
                new MinHeap(
                        new ArrayList<>(
                                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        minHeap.insert(76);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap)); //true
        System.out.println(minHeap.peek() == -5); //true
        System.out.println(minHeap.remove() == -5); //true
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap)); //true
        System.out.println(minHeap.peek() == 2); //true
        System.out.println(minHeap.remove() == 2); //true
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap)); //true
        System.out.println(minHeap.peek() == 6); //true
        minHeap.insert(87);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
    }

    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }

    static class MinHeap {
        List<Integer> heap;

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIndex = (array.size() - 2) / 2; //second last level
            for (int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
                siftDown(currentIndex, array.size() - 1, array);
            }
            return array;
        }

        //O(logn) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIndex = 2 * currentIdx + 1;

            while (childOneIndex <= endIdx) {
                int childTwoIndex = 2 * currentIdx + 2 <= endIdx ? 2 * currentIdx + 2 : -1;
                int indexToSwap;
                if (childTwoIndex != -1 && heap.get(childTwoIndex) < heap.get(childOneIndex)) {
                    indexToSwap = childTwoIndex;
                } else {
                    indexToSwap = childOneIndex;
                }

                if (heap.get(currentIdx) > heap.get(indexToSwap)) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    childOneIndex = currentIdx * 2 + 1;
                } else {
                    return; //it means current index is at its proper position
                }
            }
        }

        //O(logn) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIndex = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIndex)) {
                swap(currentIdx, parentIndex, heap);
                currentIdx = parentIndex;
                parentIndex = (currentIdx - 1) / 2;
            }
        }

        //O(1) time | O(1) space
        public int peek() {
            return heap.get(0);
        }

        //O(logn) time | O(1) space
        public int remove() {
            swap(0, heap.size() - 1, heap);// this can lead to change parent and child
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap); //shift down to proper position to satisfy min heap property
            return valueToRemove;
        }

        //O(logn) time | O(1) space
        public void insert(int value) {
            heap.add(value); //add to last
            siftUp(heap.size() - 1, heap); //shift up to proper position to satisfy min heap property because new value can be greater than parent
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }
    }
}

/*
Test Cases
Test Case 1
    {
    "array": [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41],
    "classMethodsToCall": [
    {
    "arguments": [76],
    "method": "insert"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [87],
    "method": "insert"
    }
    ]
    }
    Test Case 2
    {
    "array": [2, 3, 1],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 3
    {
    "array": [1, 2, 3, 4, 5, 6, 7, 8, 9],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 4
    {
    "array": [-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 5
    {
    "array": [-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [-8],
    "method": "insert"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [8],
    "method": "insert"
    },
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 6
    {
    "array": [427, 787, 222, 996, -359, -614, 246, 230, 107, -706, 568, 9, -246, 12, -764, -212, -484, 603, 934, -848, -646, -991, 661, -32, -348, -474, -439, -56, 507, 736, 635, -171, -215, 564, -710, 710, 565, 892, 970, -755, 55, 821, -3, -153, 240, -160, -610, -583, -27, 131],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 7
    {
    "array": [991, -731, -882, 100, 280, -43, 432, 771, -581, 180, -382, -998, 847, 80, -220, 680, 769, -75, -817, 366, 956, 749, 471, 228, -435, -269, 652, -331, -387, -657, -255, 382, -216, -6, -163, -681, 980, 913, -169, 972, -523, 354, 747, 805, 382, -827, -796, 372, 753, 519, 906],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [992],
    "method": "insert"
    }
    ]
    }
    Test Case 8
    {
    "array": [544, -578, 556, 713, -655, -359, -810, -731, 194, -531, -685, 689, -279, -738, 886, -54, -320, -500, 738, 445, -401, 993, -753, 329, -396, -924, -975, 376, 748, -356, 972, 459, 399, 669, -488, 568, -702, 551, 763, -90, -249, -45, 452, -917, 394, 195, -877, 153, 153, 788, 844, 867, 266, -739, 904, -154, -947, 464, 343, -312, 150, -656, 528, 61, 94, -581],
    "classMethodsToCall": [
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 9
    {
    "array": [-823, 164, 48, -987, 323, 399, -293, 183, -908, -376, 14, 980, 965, 842, 422, 829, 59, 724, -415, -733, 356, -855, -155, 52, 328, -544, -371, -160, -942, -51, 700, -363, -353, -359, 238, 892, -730, -575, 892, 490, 490, 995, 572, 888, -935, 919, -191, 646, -120, 125, -817, 341, -575, 372, -874, 243, 610, -36, -685, -337, -13, 295, 800, -950, -949, -257, 631, -542, 201, -796, 157, 950, 540, -846, -265, 746, 355, -578, -441, -254, -941, -738, -469, -167, -420, -126, -410, 59],
    "classMethodsToCall": [
    {
    "arguments": [2],
    "method": "insert"
    },
    {
    "arguments": [22],
    "method": "insert"
    },
    {
    "arguments": [222],
    "method": "insert"
    },
    {
    "arguments": [2222],
    "method": "insert"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "remove"
    },
    {
    "arguments": [],
    "method": "remove"
    }
    ]
    }
*/

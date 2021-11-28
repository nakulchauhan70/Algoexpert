package com.problems.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStack {
    public static void main(String[] args) {
    }

    static class Stack {
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        //O(1) time | O(1) space
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        //O(1) time | O(1) space
        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        //O(1) time | O(1) space
        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);

            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        //O(1) time | O(1) space
        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        //O(1) time | O(1) space
        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}

/*Test Cases

Test Case 1
    {
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [7],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [2],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    }
    ]
    }
    Test Case 2
    {
    "classMethodsToCall": [
    {
    "arguments": [2],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [7],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [1],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [8],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [3],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [9],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    }
    ]
    }
    Test Case 3
    {
    "classMethodsToCall": [
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [8],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [8],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [0],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [8],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [9],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    }
    ]
    }
    Test Case 4
    {
    "classMethodsToCall": [
    {
    "arguments": [2],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [0],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [5],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [4],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [4],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [11],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [-11],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    },
    {
    "arguments": [6],
    "method": "push"
    },
    {
    "arguments": [],
    "method": "getMin"
    },
    {
    "arguments": [],
    "method": "getMax"
    },
    {
    "arguments": [],
    "method": "peek"
    },
    {
    "arguments": [],
    "method": "pop"
    }
    ]
    }*/

package com.problems.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenPath {
    public static void main(String[] args) {
        // ../../foo => /foo - root directing starting with ..
        // /../../foo => ../../foo - current directory

        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
    }

    //O(n) time | O(n) space
    public static String shortenPath(String path) {
        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokens = path.split("/");
        System.out.println(Arrays.toString(tokens));

        //Double dots or directory
        List<String> filteredTokens = Arrays.stream(tokens).filter(s -> s.length() > 0 && !s.equals(".")).collect(Collectors.toList());
        System.out.println(filteredTokens);
        Stack<String> stack = new Stack<>();
        if (startsWithPath) {
            stack.add("");  //represents root directory in the stack
        }

        for (String token : filteredTokens) {
            if (token.equals("..")) {
                // ../../foo => /foo - root directing starting with ..
                // /../../foo => ../../foo - current directory
                if (stack.size() == 0 || stack.peek().equals("..")) {
                    stack.push(token);
                } else if (!stack.peek().equals("")) {
                    stack.pop();
                }
            } else {
                stack.add(token);
            }
        }

        //Handling just root directory case
        if (stack.size() == 1 && stack.get(0).equals("")) {
            return "/";
        }

        return String.join("/", stack);
    }

}

/*
Test Cases
Test Case 1
    {
    "path": "/foo/../test/../test/../foo//bar/./baz"
    }
    Test Case 2
    {
    "path": "/foo/bar/baz"
    }
    Test Case 3
    {
    "path": "foo/bar/baz"
    }
    Test Case 4
    {
    "path": "/../../foo/bar/baz"
    }
    Test Case 5
    {
    "path": "../../foo/bar/baz"
    }
    Test Case 6
    {
    "path": "/../../foo/../../bar/baz"
    }
    Test Case 7
    {
    "path": "../../foo/../../bar/baz"
    }
    Test Case 8
    {
    "path": "/foo/./././bar/./baz///////////test/../../../kappa"
    }
    Test Case 9
    {
    "path": "../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../.."
    }
    Test Case 10
    {
    "path": "/../../../this////one/./../../is/../../going/../../to/be/./././../../../just/a/forward/slash/../../../../../.."
    }
    Test Case 11
    {
    "path": "../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../../foo"
    }
    Test Case 12
    {
    "path": "/../../../this////one/./../../is/../../going/../../to/be/./././../../../just/a/forward/slash/../../../../../../foo"
    }
    Test Case 13
    {
    "path": "foo/bar/.."
    }
    Test Case 14
    {
    "path": "./foo/bar"
    }
    Test Case 15
    {
    "path": "foo/../.."
    }
    Test Case 16
    {
    "path": "/"
    }
    Test Case 17
    {
    "path": "./.."
    }
*/
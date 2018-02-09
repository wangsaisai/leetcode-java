/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bamboo.leetcode.solution;

import java.util.Stack;

public class LongestValidParentheses {

  public static int longestValidParentheses(String s) {
    char[] inputs = s.toCharArray();
    int len = inputs.length;

    Stack<Integer> stack = new Stack<>();

    for (int i=0; i<len; i++) {
      if (inputs[i] == '(') {
        stack.push(i);
      } else if (!stack.isEmpty() && inputs[stack.peek()] == '(') {
        stack.pop();
      } else {
        stack.push(i);
      }
    }

    int longest = 0;
    if (stack.isEmpty()) {
      longest = len;
    } else {
      int big = len;
      int small = -1;
      while (!stack.isEmpty()) {
        small = stack.pop();
        int dis = big - small - 1;
        longest = longest > dis ? longest : dis;

        big = small;
      }
      longest = longest > big ? longest : big;
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("())"));
    System.out.println(longestValidParentheses("(()"));
    System.out.println(longestValidParentheses("))()())"));
    System.out.println(longestValidParentheses("()()()"));

  }

}

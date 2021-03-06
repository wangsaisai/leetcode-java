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

package bamboo.leetcode.commmon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Utils {

  public static void printListNode(ListNode listNode) {
    List<Integer> list = new LinkedList<>();
    while (listNode != null) {
      list.add(listNode.val);
      listNode = listNode.next;
    }

    Integer[] result = list.toArray(new Integer[]{});
    System.out.println(Arrays.toString(result));
  }

  public static ListNode buildListNode(int... values) {
    ListNode current = new ListNode(0);
    ListNode head = current;

    for (int val : values) {
      ListNode node = new ListNode(val);
      current.next = node;
      current = node;
    }

    return head.next;
  }
}

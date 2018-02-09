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

import bamboo.leetcode.commmon.ListNode;
import bamboo.leetcode.commmon.Utils;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class KListSort {

  static class Tuple<T1, T2> {
    public T1 first;
    public T2 second;

    public Tuple(T1 first, T2 second) {
      this.first = first;
      this.second = second;
    }

    public static <T1, T2> Tuple of(T1 first, T2 second) {
      return new Tuple(first, second);
    }
  }

  // contain same value
  public static ListNode mergeKLists2(ListNode[] lists) {
    TreeSet<Tuple<ListNode, Integer>> set = new TreeSet<>(
        (o1, o2) -> o1.first.val == o2.first.val ? o1.second - o2.second : o1.first.val - o2.first.val
    );

    ListNode head = new ListNode(0);
    ListNode current = head;

    for (int i=0; i<lists.length; i++) {
      ListNode node = lists[i];
      if (node != null) {
        set.add(Tuple.of(node, i));
      }
    }

    while (!set.isEmpty()) {
      Tuple<ListNode, Integer> tuple = set.first();
      ListNode node = tuple.first;
      int index = tuple.second;
      set.remove(tuple);

      current.next = node;
      current = node;
      node = node.next;
      if (node != null) {
        set.add(Tuple.of(node, index));
      }
    }

    return head.next;
  }

  // no same value
  public static ListNode mergeKLists(ListNode[] lists) {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    ListNode head = new ListNode(0);
    ListNode current = head;

    for (int i=0; i<lists.length; i++) {
      ListNode node = lists[i];
      if (node != null) {
        map.put(node.val, i);
      }
//      lists[i] = node.next;
    }

    while (!map.isEmpty()) {
      Map.Entry<Integer, Integer> entry = map.firstEntry();
      int val = entry.getKey();
      int index = entry.getValue();
      map.remove(val);

      ListNode node = lists[index];
      if (node != null) {
        current.next = node;
        current = node;
        lists[index] = node.next;

        node = node.next;
        if (node != null)
          map.put(node.val, index);
      }
    }

    return head.next;
  }


  public static void main(String[] args) {
    ListNode n1 = Utils.buildListNode(1, 4, 7);
    ListNode n2 = Utils.buildListNode(2, 5, 8);

    Utils.printListNode(n1);

    Utils.printListNode(mergeKLists2(new ListNode[]{n1,n2}));


    ListNode n3 = Utils.buildListNode(1, 4, 7);
    ListNode n4 = Utils.buildListNode(2, 5, 8);
    ListNode n5 = Utils.buildListNode(2, 6, 9);
    Utils.printListNode(mergeKLists2(new ListNode[]{n5, n4, n3}));

  }



}

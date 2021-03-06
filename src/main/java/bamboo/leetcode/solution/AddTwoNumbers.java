package bamboo.leetcode.solution;

import bamboo.leetcode.commmon.ListNode;

/**
 * @url https://leetcode.com/problems/add-two-numbers
 *
 * @desc You are given two non-empty linked lists representing two non-negative integers.
 *       The digits are stored in reverse order and each of their nodes contain a single digit.
 *       Add the two numbers and return it as a linked list.
 *       You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @example Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *          Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(0);
    ListNode prev = head;

    int carry = 0;

    while(l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if(l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      ListNode node = new ListNode(sum%10);
      prev.next = node;
      prev = node;
      carry = sum/10;
    }

    return head.next;
  }

}

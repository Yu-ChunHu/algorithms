package leetcode.medium;

import leetcode.medium.collection.ListNode;

/**
 * 2. Add Two Numbers
 * given two non-empty linked lists/
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode r0 = new ListNode(-1);
    int carry = 0;
    ListNode r = r0;
    while (hasValueToAdd(l1, l2, carry)) {
      int sum = add(l1, l2, carry);
      if (sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      } else {
        carry = 0;
      }

      r.next = new ListNode(sum);

      r = getNextNode(r);
      l1 = getNextNode(l1);
      l2 = getNextNode(l2);
    }
    return r0.next;
  }

  private boolean hasValueToAdd(ListNode l1, ListNode l2, int carry) {
    return l1 != null || l2 != null || carry > 0;
  }

  private int add(ListNode l1, ListNode l2, int carry) {
    int l1Val = (l1 == null) ? 0 : l1.val;
    int l2Val = (l2 == null) ? 0 : l2.val;
    return l1Val + l2Val + carry;
  }

  private ListNode getNextNode(ListNode n) {
    return (n == null) ? null : n.next;
  }
}
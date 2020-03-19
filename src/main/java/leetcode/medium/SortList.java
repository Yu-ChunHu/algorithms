package leetcode.medium;

import leetcode.medium.collection.ListNode;

public class SortList {
  public ListNode sort(ListNode head) {
    if (head == null)
      return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int size = getListSize(head);
    bottemUpMergeSort(dummy, size);
    
    return dummy.next;
  }

  private int getListSize(ListNode head) {
    int size = 0;
    while (head != null) {
      head = head.next;
      size++;
    }
    return size;
  }

  private void bottemUpMergeSort(ListNode dummy, int size) {
    for (int step = 1; step < size; step *= 2) {
      ListNode prev = dummy;
      ListNode cur = dummy.next;
      while (cur != null) {
        ListNode left = cur;
        ListNode right = divide(left, step);
        cur = divide(right, step);
        prev = merge(left, right, prev);
      }
    }
  }

  private ListNode divide(ListNode left, int step) {
    if (left == null || left.next == null)
      return null;

    for (int i = 1; left.next != null && i < step; i++)
      left = left.next;
    
    ListNode right = left.next;
    left.next = null;
    return right;
  }

  private ListNode merge(ListNode left, ListNode right, ListNode sorted) {
    while (hasNodeToCompare(left, right)) {
      if (left.val <= right.val) {
        sorted.next = left;
        left = left.next;
      } else {
        sorted.next = right;
        right = right.next;
      }
      sorted = sorted.next;
    }

    appendRemainingNodes(sorted, left, right);
    return getLastNodeOfList(sorted);
  }

  private boolean hasNodeToCompare(ListNode left, ListNode right) {
    return left != null && right != null;
  }

  private void appendRemainingNodes(ListNode sorted, ListNode left, ListNode right) {
    if (left == null)
      sorted.next = right;
    if (right == null)
      sorted.next = left;
  }

  private ListNode getLastNodeOfList(ListNode node) {
    while (node.next != null)
      node = node.next;
    return node;
  }
}
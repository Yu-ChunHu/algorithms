package leetcode.medium;

import leetcode.medium.collection.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Sort a linked list in O(n log n) time using constant space complexity
 */
class SortListTest {
  private SortList sortAlg = new SortList();

  @Test
  void nullList() {
    sortAlg.sort(null);
  }

  @Test 
  void ascList() {
    assertSortAlg(new int[] {1, 2, 3}, new int[] {1, 2, 3});
  }

  @Test 
  void descList() {
    assertSortAlg(new int[] {3, 2, 1}, new int[] {1, 2, 3});
  }

  @Test
  void integration() {
    assertSortAlg(new int[] {5,2,3,3,1,4,6,7,3}, new int[] {1,2,3,3,3,4,5,6,7});
  }

  private void assertSortAlg(int[] in, int[] expected) {
    ListNode input = makeNodeList(in);
    ListNode result = sortAlg.sort(input);
    verify(result, expected);
  }

  private ListNode makeNodeList(int[] val) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int i = 0; i < val.length; i++) {
      ListNode node = new ListNode(val[i]);
      cur.next = node;
      cur = cur.next;
    }
    return dummy.next;
  }

  private void verify(ListNode result, int[] expected) {
    for (int e : expected) {
      assertNotNull(result);
      assertEquals(e, result.val);
      result = result.next;
    }
  }

  class SortList {
    public ListNode sort(ListNode head) {
      if (head == null)
        return null;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      int size = 0;
      while (head != null) {
        head = head.next;
        size++;
      }

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
      return dummy.next;
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
      while (left != null && right != null) {
        if (left.val <= right.val) {
          sorted.next = left;
          left = left.next;
        } else {
          sorted.next = right;
          right = right.next;
        }
        sorted = sorted.next;
      }

      if (left == null)
        sorted.next = right;
      if (right == null)
        sorted.next = left;
      while (sorted.next != null)
        sorted = sorted.next;
      return sorted;
    }
  }
}
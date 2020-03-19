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
}
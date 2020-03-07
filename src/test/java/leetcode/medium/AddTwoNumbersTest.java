package leetcode.medium;

import leetcode.medium.collection.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {
  private static AddTwoNumbers sumTwo;

  @BeforeAll
  static void setUp() {
    sumTwo = new AddTwoNumbers();
  }

  @Test
  void sumNoNextList() {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);

    ListNode r = sumTwo.addTwoNumbers(l1, l2);
    
    assertEquals(3, r.val);
  }

  @Test
  void sumListWithCarry() {
    ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(9);

    ListNode r = sumTwo.addTwoNumbers(l1, l2);
    
    assertEquals(8, r.val);
    assertEquals(1, r.next.val);
  }

  @Test
  void sum92to465() {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(9);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode r = sumTwo.addTwoNumbers(l1, l2);

    assertEquals(7, r.val);
    assertEquals(5, r.next.val);
    assertEquals(5, r.next.next.val);
  }

  @Test
  void sum342to465() {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode r = sumTwo.addTwoNumbers(l1, l2);

    assertEquals(7, r.val);
    assertEquals(0, r.next.val);
    assertEquals(8, r.next.next.val);
  }
}
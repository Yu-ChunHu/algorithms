package data_structure.priority_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteBinaryHeapsTest {

  private PriorityQueue<Integer> pq;

  @BeforeEach
  void setUp() {
    pq = new CompleteBinaryHeaps<>(10);
  }

  @Test
  void findTop1() {
    assertTrue(pq.isEmpty());
    pq.insert(1);
    pq.insert(10);
    pq.insert(1);
    pq.insert(3);
    pq.insert(13);
    pq.insert(4);
    int top1 = pq.delMax();
    assertFalse(pq.isEmpty());
    assertEquals(13, top1);
  }
}
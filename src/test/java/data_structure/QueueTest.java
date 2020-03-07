package data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class QueueTest {
  protected Queue<Integer> queue;

  @BeforeEach
  void setUpQueue() {
    queue = initialQueue();
  }

  protected abstract Queue<Integer> initialQueue();

  @Test
  void en1de1() {
    queue.enqueue(1);
    int result = queue.dequeue();
    assertEquals(1, result);
  }

  @Test
  void deEmptyQueue() {
    Integer result = queue.dequeue();
    assertNull(result);
  }

  @Test
  void integration() {
    queue.enqueue(1);
    queue.enqueue(2);
    int r1 = queue.dequeue();
    int r2 = queue.dequeue();
    queue.enqueue(3);
    int r3 = queue.dequeue();
    Integer r4 = queue.dequeue();
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    int r5 = queue.dequeue();

    assertEquals(1, r1);
    assertEquals(2, r2);
    assertEquals(3, r3);
    assertNull(r4);
    assertEquals(4, r5);
  }
}

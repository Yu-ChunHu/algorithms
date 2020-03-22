package data_structure.priority_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
  private static Stream<PriorityQueue> provideImplementation() {
    return Stream.of(
            new SimplePriorityQueue<>(10),
            new CompleteBinaryHeaps<>(10)
    );
  }
  
  @ParameterizedTest
  @MethodSource("provideImplementation")
  void findTop1(PriorityQueue<Integer> pq) {
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
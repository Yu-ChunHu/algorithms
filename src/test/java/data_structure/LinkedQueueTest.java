package data_structure;

class LinkedQueueTest extends QueueTest {
  @Override
  protected Queue<Integer> initialQueue() {
    return new LinkedQueue<>();
  }
}
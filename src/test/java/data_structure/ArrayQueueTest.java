package data_structure;

class ArrayQueueTest extends QueueTest {
  @Override
  protected Queue<Integer> initialQueue() {
    return new ArrayQueue<>();
  }
}
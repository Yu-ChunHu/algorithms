package data_structure;

class LinkedStackTest extends StackTest {
  @Override
  protected Stack<Integer> initialStack() {
    return new LinkedStack<>();
  }
}
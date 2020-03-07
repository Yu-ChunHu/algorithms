package data_structure;

class ArrayStackTest extends StackTest {
  @Override
  protected Stack<Integer> initialStack() {
    return new ArrayStack<>(10);
  }
}
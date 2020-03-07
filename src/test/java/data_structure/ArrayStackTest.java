package data_structure;

import org.junit.jupiter.api.Test;

class ArrayStackTest extends StackTest {
  @Override
  protected Stack<Integer> initialStack() {
    return new ArrayStack<>();
  }

  @Test
  void pushOversize() {
    this.stack.push(1);
    this.stack.push(2);
    this.stack.push(3);
    this.stack.push(4);
    this.stack.push(5);
    this.stack.push(6);
    this.stack.push(7);
    this.stack.push(8);
    this.stack.push(9);
    this.stack.push(10);
    this.stack.push(11);
  }
}
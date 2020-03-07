package data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class StackTest {
  private Stack<Integer> stack;

  @BeforeEach
  void setUpStack() {
    stack = initialStack();
  }

  protected abstract Stack<Integer> initialStack();

  @Test
  void push1pop1() {
    stack.push(1);
    int result = stack.pop();
    assertEquals(1, result);
  }

  @Test
  void popEmptyStack() {
    Integer result = stack.pop();
    assertNull(result);
  }

  @Test
  void integration() {
    stack.push(1);
    stack.push(2);
    int r1 = stack.pop();
    int r2 = stack.pop();
    stack.push(3);
    int r3 = stack.pop();
    Integer r4 = stack.pop();
    stack.push(4);
    stack.push(5);
    stack.push(6);
    int r5 = stack.pop();

    assertEquals(2, r1);
    assertEquals(1, r2);
    assertEquals(3, r3);
    assertNull(r4);
    assertEquals(6, r5);
  }
}
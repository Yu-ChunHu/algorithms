package data_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IterableLinkedStackTest {
  @Test
  void forEachLoopThroughStack() {
    IterableLinkedStack<Integer> s = new IterableLinkedStack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    String result = "";
    for (int i : s)
      result += String.valueOf(i);
    assertEquals("54321", result);
  }
}
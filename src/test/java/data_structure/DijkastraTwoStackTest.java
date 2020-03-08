package data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkastraTwoStackTest {
  private DijkastraTwoStack calculator;

  @BeforeEach
  void setUp() {
    calculator = new DijkastraTwoStack();
  }

  @Test
  void Given1Plus1() {
    int r = calculator.calculate("1 + 1");
    assertEquals(2, r);
  }

  @Test
  void Given2Minus1() {
    int r = calculator.calculate("2 - 1");
    assertEquals(1, r);
  }

  @Test
  void integration() {
    int r = calculator.calculate("3 + 20 + ( 47 - ( 2 - 2 ) ) - 1");
    assertEquals(69, r);
  }
}
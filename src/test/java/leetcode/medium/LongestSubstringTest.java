package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {
  private LongestSubstring longSub = new LongestSubstring();

  @Test
  void emptyString() {
    assertEqualsExpected(null, 0);
    assertEqualsExpected("", 0);
  }

  @Test
  void differentChar() {
    assertEqualsExpected("abc", 3);
  }

  @Test
  void sameChar() {
    assertEqualsExpected("aaa", 1);
  }

  @Test
  void integration() {
    assertEqualsExpected("abcabcdaa", 4);
    assertEqualsExpected("tcmmest", 4);
  }

  private void assertEqualsExpected(String input, int expected) {
    int result = longSub.getLength(input);
    assertEquals(expected, result);
  }
}
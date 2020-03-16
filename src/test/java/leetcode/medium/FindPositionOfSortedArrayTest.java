package leetcode.medium;

import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPositionOfSortedArrayTest {
  private FindPositionOfSortedArray finder = new FindPositionOfSortedArray();
  
  @Test
  void emptyArray() {
    assertEqualExpected(new int[]{}, 0, new int[]{-1, -1});
  }

  @Test
  void begining() {
    assertEqualExpected(new int[]{0, 1, 2, 3}, 0, new int[]{0, 0});
  }

  @Test
  void end() {
    assertEqualExpected(new int[]{0, 1, 2, 3}, 3, new int[]{3, 3});
  }

  @Test
  void duplicate() {
    assertEqualExpected(new int[]{0, 1, 2, 3, 3, 3, 3}, 3, new int[]{3, 6});
    assertEqualExpected(new int[]{0, 0, 0, 3, 3, 3, 3}, 0, new int[]{0, 2});
  }

  @Test
  void integration() {
    assertEqualExpected(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4});
    assertEqualExpected(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1});
  }

  private void assertEqualExpected(int[] input, int target, int[] expected) {
    int[] result = finder.searchRange(input, target);
    IntStream.range(0, 2).forEach(i -> assertEquals(expected[i], result[i]));
  }
}
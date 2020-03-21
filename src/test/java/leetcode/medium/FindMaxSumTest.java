package leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxSumTest {
  private FindMaxSum findMaxSum = new FindMaxSum();

  @Test
  void noSumDivThree() {
    assertExpectedSum(0, 4);
  }

  @Test
  void hasSumDivByThree() {
    assertExpectedSum(18,3,6,5,1,8);
    assertExpectedSum(12,1,2,3,4,4);
    assertExpectedSum(15,2,6,2,2,7);
  }

  void assertExpectedSum(int expected, int... nums) {
    int result = findMaxSum.maxSumDivThree(nums);
    assertEquals(expected, result);
  }
}
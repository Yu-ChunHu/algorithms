package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestSightseeingPairTest {
  private BestSightseeingPair pair = new BestSightseeingPair();

  @Test
  void integration() {
    int score = pair.maxScoreSightseeingPair(new int[] {8,1,5,2,6});
    assertEquals(11, score);

    score = pair.maxScoreSightseeingPair(new int[] {1000,1,1,1,1});
    assertEquals(1000, score);
  }
}
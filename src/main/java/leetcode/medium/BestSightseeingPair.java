package leetcode.medium;

/**
 * 1014. Best Sightseeing Pair
 * Given an array A of positive integers, 
 * A[i] represents the value of the i-th sightseeing spot, 
 * and two sightseeing spots i and j have distance j - i between them.
 * 
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {
  public int maxScoreSightseeingPair(int[] A) {
    int maxScore = 0;
    int prev = 0;
    for (int a : A) {
      maxScore = Math.max(maxScore, prev + a);
      prev = Math.max(prev, a) - 1;
    }
    return maxScore;
  }
}
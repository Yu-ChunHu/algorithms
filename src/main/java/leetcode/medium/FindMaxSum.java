package leetcode.medium;
/**
 * 1262. Greatest Sum Divisible by Three
 * Given an array nums of integers, 
 * we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class FindMaxSum {
  public int maxSumDivThree(int[] nums) {
    int sum = 0;
    int leftOne = 20000;
    int leftTwo = 20000;
    for (int num : nums) {
      sum += num;
      if (num % 3 == 1) {
        leftTwo = Math.min(leftTwo, leftOne + num);
        leftOne = Math.min(leftOne, num);
      } else if (num % 3 == 2) {
        leftOne = Math.min(leftOne, leftTwo + num);
        leftTwo = Math.min(leftTwo, num);
      }
    }

    if (sum % 3 == 1)
      sum -= leftOne;
    else if (sum % 3 == 2)
      sum -= leftTwo;

    return sum;
  }
}
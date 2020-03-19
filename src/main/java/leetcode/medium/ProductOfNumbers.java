package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
  private List<Integer> nums = new ArrayList<>();

  public void add(int num) {
    if (num == 0)
      nums = new ArrayList<>();
    else {
      int size = nums.size();
      int product = (size > 0)? nums.get(size - 1) * num : num;
      nums.add(product);
    }
  }

  public int getProduct(int k) {
    int size = nums.size();
    if (size < k)
      return 0;
    else if (size == k)
      return nums.get(size - 1);
    else
      return nums.get(size - 1) / nums.get(size - k - 1);
  }
}
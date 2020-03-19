package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
  private List<Integer> nums = new ArrayList<>();

  public void add(int num) {
    nums.add(num);
  }

  public int getProduct(int k) {
    int product = 1;
    int lastIdx = nums.size() - 1;
    for (int i = 0; i < k; i++) {
      int cur = nums.get(lastIdx - i);
      if (cur == 0)
        return 0;
      product *= cur;
    }
    return product;
  }
}
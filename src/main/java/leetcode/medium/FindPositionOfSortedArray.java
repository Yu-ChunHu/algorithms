package leetcode.medium;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class FindPositionOfSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int size = nums.length;
    return find(nums, target, 0, size - 1);
  }

  private int[] find(int[] nums, int target, int low, int high) {
    if (low > high)
      return new int[] {-1, -1};

    int mid = getMiddleIndex(low, high);
    if (target < nums[mid]) {
      return findLeft(nums, target, low, mid);
    } else if (target > nums[mid]) {
      return findRight(nums, target, mid, high);
    } else {
      int lf = mid;
      if (mid - 1 >= low && nums[mid - 1] == target)
        lf = findLeft(nums, target, low, mid)[0];

      int rf = mid;
      if (mid + 1 <= high && nums[mid + 1] == target)
        rf = findRight(nums, target, mid, high)[1];
      return new int[] {lf, rf};
    }
  }

  private int getMiddleIndex(int low, int high) {
    return low + ((high - low) / 2);
  }

  private int[] findLeft(int[] nums, int target, int low, int mid) {
    return find(nums, target, low, mid - 1);
  }

  private int[] findRight(int[] nums, int target, int mid, int high) {
    return find(nums, target, mid + 1, high);
  }
}
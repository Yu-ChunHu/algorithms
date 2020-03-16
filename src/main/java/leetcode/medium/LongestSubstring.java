package leetcode.medium;

import java.util.Map;
import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters
 */
public class LongestSubstring {
  public int getLength(String s) {
    if (s == null || "".equals(s))
      return 0;
    
    char[] c = s.toCharArray();
    int N = c.length;
    Map<Character, Integer> idx = new HashMap<>();
    int i = 0;
    int j = 0;
    int ans = 0;
    while(i < N && j < N) {
      char curr = c[j];
      Integer duplicateIdx = idx.get(curr);
      if (duplicateIdx == null || duplicateIdx < i) {
        ans = Math.max(ans, j - i + 1);
      } else {
        i = duplicateIdx;
      }
      idx.put(c[j], ++j);
    }
    return ans;
  }
}
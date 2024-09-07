import java.util.*;

/**
 * 不定长滑动窗口
 * 
 * Q3的变体
 * 
 * O(n) time | O(26) = O(1) space
 */
class Solution3090 {
  public int maximumLengthSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0;

    for (int l = 0, r = 0; r < s.length(); r++) {
      char curr = s.charAt(r);
      map.put(curr, map.getOrDefault(curr, 0) + 1);
      while (map.get(curr) > 2) {
        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        l++;
      }
      ans = Math.max(ans, r - l + 1);
    }

    return ans;
  }
}
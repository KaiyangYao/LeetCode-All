import java.util.*;

/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
 * 类似: 1965, Q904
 */
class Solution {
  public int maxSubarrayLength(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      int ans = 0;

      for (int l = 0, r = 0; r < n; r++) {
          int curr = nums[r];
          map.put(curr, map.getOrDefault(curr, 0) + 1);

          while (map.get(curr) > k) {
              map.put(nums[l], map.get(nums[l]) - 1);
              l++;
          }

          ans = Math.max(ans, r - l + 1);
      }

      return ans;
  }
}
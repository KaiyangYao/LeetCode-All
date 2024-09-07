import java.util.*;

/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
 * 类似: Q2958, Q904
 */
class Solution1695 {
  public int maximumUniqueSubarray(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      int sum = 0;
      int ans = 0;

      for (int l = 0, r = 0; r < n; r++) {
          int curr = nums[r];
          map.put(curr, map.getOrDefault(curr, 0) + 1);
          sum += nums[r];

          while (map.get(curr) > 1) {
              map.put(nums[l], map.get(nums[l]) - 1);
              sum -= nums[l];
              l++;
          }

          ans = Math.max(ans, sum);
      }

      return ans;
  }
}
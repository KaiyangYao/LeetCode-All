import java.util.*;

/* 
 * 20240905
 * 定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
 * 因为值域很小，可以用计数排序暴力枚举
 * 
*/

class Solution2653 {
  public int[] getSubarrayBeauty(int[] nums, int k, int x) {
      Map<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      int[] ans = new int[n - k + 1];

      for (int i = 0; i < k - 1; i++) {
          int curr = nums[i];
          map.put(curr, map.getOrDefault(curr, 0) + 1);
      }

      for (int i = k - 1; i < n; i++) {
          int curr = nums[i];
          map.put(curr, map.getOrDefault(curr, 0) + 1);
          
          if (i - k >= 0) {
              int prev = nums[i - k];
              map.put(prev, map.get(prev) - 1);
              if (map.get(prev) == 0) {
                  map.remove(prev);
              }
          }

          int currTotal = 0;
          for (int j = -50; j <= 50; j++) {
              if (!map.containsKey(j)) continue;
              currTotal += map.get(j);
              if (currTotal >= x) {
                  ans[i + 1 - k] = j < 0 ? j : 0;
                  break;
              }
          }
      }

      return ans;
  }
}
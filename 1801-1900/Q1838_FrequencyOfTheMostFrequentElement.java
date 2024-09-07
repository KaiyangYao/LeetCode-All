import java.util.*;

/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(1) space
 */

class Solution1838 {
  public int maxFrequency(int[] nums, int k) {
      Arrays.sort(nums);
      int n = nums.length;
      long count = 0;
      int ans = 1;

      for (int l = 0, r = 1; r < n; r++) {
          count += (long) (nums[r] - nums[r - 1]) * (r - l);
          while(count > k) {
              count -= (nums[r] - nums[l]);
              l++;
          }
          ans = Math.max(ans, r - l + 1);
      }

      return ans;
  }
}
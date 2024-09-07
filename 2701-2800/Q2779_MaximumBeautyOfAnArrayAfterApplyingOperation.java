import java.util.*;

/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n log n) time | O(log n) space for sorting
 * 
 * 转化成滑动窗口!
 * 排序看最小的 + k 和 最大的 - k 之间有没有交集
 * 如果有的话就可以连上！
 */
class Solution2779 {
  public int maximumBeauty(int[] nums, int k) {
      Arrays.sort(nums);
      int ans = 0;

      for (int l = 0, r = 0; r < nums.length; r++) {
          while (nums[r] - k > nums[l] + k) {
              l++;
          }
          ans = Math.max(ans, r - l + 1);
      }

      return ans;
  }
}
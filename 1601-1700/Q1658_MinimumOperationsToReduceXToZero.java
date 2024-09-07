/**
 * 20240905
 * 
 * 不定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
 * 把问题转换成「从 nums 中移除一个最长的子数组，使得剩余元素的和为 x」。
 */
class Solution1658 {
  public int minOperations(int[] nums, int x) {
      int n = nums.length;
      int totalSum = 0;
      for (int i = 0; i < n; i++) {
          totalSum += nums[i];
      }
      int target = totalSum - x;
      if (target < 0) {
          return -1;
      } 

      int sum = 0;
      int cnt = -1;
      for (int l = 0, r = 0; r < n; r++) {
          sum += nums[r];
          while (sum > target) {
              sum -= nums[l];
              l++;
          }
          if (sum == target) {
              cnt = Math.max(cnt, r - l + 1);
          }
      }

      return cnt == -1 ? -1 : n - cnt;
  }
}
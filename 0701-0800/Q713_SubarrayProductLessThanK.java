/**
 * 20240904
 * 滑动窗口
 * O(n) time | O(1) space
 */
class Solution713 {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int n = nums.length;
    int prod = 1;
    int ans = 0;

    for (int l = 0, r = 0; r < n; r++) {
      prod *= nums[r];
      while (prod >= k && l <= r) {
        prod /= nums[l++];
      }
      ans += r - l + 1; // 已r为右端点的子数组个数
    }

    return ans;
  }
}
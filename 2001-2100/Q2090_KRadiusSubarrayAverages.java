/* 
 * 20240904
 * 定长滑动窗口
 * 
 * O(n) time | O(n) space
 * 
*/
class Solution2090 {
  public int[] getAverages(int[] nums, int k) {
      int n = nums.length;
      int[] ans = new int[n];
      int len = 2 * k + 1;
      long sum = 0;

      for (int i = 0; i < n; i++) {
          ans[i] = -1;
      }

      if (len > n) {
          return ans;
      }

      for (int i = 0; i < len; i++) {
          sum += nums[i];
      }

      ans[k] = (int) (sum / len);

      for (int j = k + 1; j < n - k; j++) {
          sum = sum + nums[j + k] - nums[j - k - 1];
          ans[j] = (int) (sum / len);
      }

      return ans;
  }
}
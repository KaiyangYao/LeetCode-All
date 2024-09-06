/* 
 * 20240905
 * 定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution1176 {
  public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
      int sum = 0;
      int ans = 0;
      int n = calories.length;

      for (int i = 0; i < k; i++) {
          sum += calories[i];
      }
      
      ans = sum < lower ? -1 : (sum > upper ? 1 : 0);

      for (int i = k; i < n; i++) {
          sum += calories[i] - calories[i - k];
          int delta = sum < lower ? -1 : (sum > upper ? 1 : 0);
          ans += delta;
      }

      return ans;
  }
}
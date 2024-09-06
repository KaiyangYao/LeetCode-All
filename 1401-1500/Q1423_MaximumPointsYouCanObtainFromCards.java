/* 
 * 20240905
 * 定长滑动窗口
 * 
 * 转换取反思想！为了最大化拿走的点数和，应当最小化剩下的点数和。
 * O(n) time | O(1) space
 * 
*/

class Solution1423 {
  public int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;
      int target = n - k;
      int sum = 0;
      int ans = Integer.MAX_VALUE;

      int totalSum = 0;
      for (int i = 0; i < n; i++) {
          totalSum += cardPoints[i];
      }

      for (int i = 0; i < target; i++) {
          sum += cardPoints[i];
      }
      ans = sum;

      for (int i = target; i < n; i++) {
          sum += cardPoints[i] - cardPoints[i - target];
          ans = Math.min(ans, sum);
      }

      return totalSum - ans;
  }
}
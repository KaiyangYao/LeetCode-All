/* 
 * 20240904
 * 两个相同位置定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution1052 {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      int n = customers.length;
      int ans = -1;
      int sum = 0;
      int secretSum = 0;
      int secretDoubleCnt = 0;

      for (int i = 0; i < n; i++) {
          if (grumpy[i] == 0) {
              sum += customers[i];
          }
      }

      for (int i = 0; i < minutes; i++) {
          secretSum += customers[i];
          if (grumpy[i] == 0) {
              secretDoubleCnt += customers[i];
          }
      }
      
      ans = Math.max(ans, sum - secretDoubleCnt + secretSum);

      for (int i = minutes; i < n; i++) {
          secretSum += customers[i];
          secretSum -= customers[i - minutes];
          if (grumpy[i] == 0) {
              secretDoubleCnt += customers[i];
          }
          if (grumpy[i - minutes] == 0) {
              secretDoubleCnt -= customers[i - minutes];
          }
          ans = Math.max(ans, sum - secretDoubleCnt + secretSum);
      }

      return ans;
  }
}
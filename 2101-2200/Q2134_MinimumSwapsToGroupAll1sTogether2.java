/* 
 * 20240905
 * 定长滑动窗口
 * 
 * O(n) time | O(1) space
 * 
*/
class Solution2134 {
  public int minSwaps(int[] nums) {
      int numOnes = 0;
      int sum = 0;
      int n = nums.length;
      int minSwitch;

      for (int i = 0; i < n; i++) {
          numOnes += nums[i];
      }

      for (int i = 0; i < numOnes; i++) {
          sum += nums[i];
      }

      minSwitch = numOnes - sum;

      for (int i = numOnes; i < n + numOnes; i++) {
          sum += nums[i % n] - nums[(i - numOnes + n) % n]; 
          minSwitch = Math.min(minSwitch, numOnes - sum);
      }

      return minSwitch;
  }
}
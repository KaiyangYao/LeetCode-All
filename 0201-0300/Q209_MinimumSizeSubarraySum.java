/**
 * Sliding Window
 * 
 * 2023/07/06
 */

 /**
  * O(n) time | O(1) space
  */
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum - nums[l] >= target ) {
                sum -= nums[l];
                l++;
            }
            if (sum >= target) {
                result = Math.min(result, r - l + 1);
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
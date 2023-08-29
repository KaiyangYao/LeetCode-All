/**
 * DP
 * 
 * 2023/07/23
 */

/**
 * O(n) time
 * O(1) space
 */
class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i][0]: 到第i个如果拿了这个的最大值
        // dp[i][1]: 到第i个如果不拿这个的最大值
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
/**
 * DP
 * 
 * 2023/07/23
 */

/**
 * O(n) time
 * O(1) space
 */

// dp[i] = 第 i-1 个物品的最大值
class Solution198_01 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}

/**
 * O(n) time | O(1) space
 */
class Solution198_02 {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int curr = nums[0];
        for (int i = 2; i < n + 1; i++) {
            int temp = Math.max(prev + nums[i - 1], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

class Solution198_03 {
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
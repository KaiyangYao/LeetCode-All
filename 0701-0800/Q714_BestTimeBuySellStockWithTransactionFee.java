/**
 * 动态规划
 * 
 * 2023/06/11
 */

/**
 * O(n) time | O(n) space
 */
class Solution714_01 {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }
}

/**
 * 优化 O(1) space
 */
class Solution714_02 {
    public int maxProfit(int[] prices, int fee) {
        int profit0 = 0, profit1 = -prices[0] - fee;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            int newProfit1 = Math.max(profit1, profit0 - prices[i] - fee);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }
}
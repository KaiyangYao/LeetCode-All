/*
 * Greedy
 * O(n) time | O(1) space
 * 
 * 2022/11/05
 */
class Solution122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}

/**
 * 动态规划
 * O(n) time | O(n) space
 * 和前一题区别: 如果 k 为正无穷，则 k 和 k - 1 可以看成是相同的
 * 所以 dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); 可以
 * 前面只能是dp[i][1] = Math.max(dp[i - 1][1], -prices[i]); 因为先顶了一次交易
 */
class Solution122_02 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }
}

/**
 * 压缩到 O(1) space
 */
class Solution122_03 {
    public int maxProfit(int[] prices) {
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            int newProfit1 = Math.max(profit1, profit0 - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }
}
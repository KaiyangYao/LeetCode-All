/*
 * O(n) time | O(1) space
 * 
 * 2022/11/05
 */
class Solution121_01 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}

// 动态规划
/**
 * 用 n 表示股票价格数组的长度；
 * 用 i 表示第 i 天（i 的取值范围是 0 到 n - 1）；
 * 用 k 表示允许的最大交易次数；
 * 用 T[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
 * T[i][k][0] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 0 份股票的情况下可以获得的最大收益；
 * T[i][k][1] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 1 份股票的情况下可以获得的最大收益。
 */

class Solution121_02 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        // 结束时持有 0 份股票的收益一定大于持有 1 份股票的收益。
        return dp[length - 1][0];
    }
}

/**
 * 压缩空间到O(1)
 */
class Solution121_03 {
    public int maxProfit(int[] prices) {
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }
}
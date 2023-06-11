/**
 * 动态规划
 * 
 * 2023/06/11
 */

/**
    用 n 表示股票价格数组的长度；
    用 i 表示第 i 天（i 的取值范围是 0 到 n - 1）；
    用 k 表示允许的最大交易次数；
    用 T[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
    T[i][k][0] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 0 份股票的情况下可以获得的最大收益；
    T[i][k][1] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 1 份股票的情况下可以获得的最大收益。
 */

/**
 * O(n) time | O(n) space
 */
class Solution123_01 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[length - 1][2][0];
    }
}

/**
 * 优化空间
 * O(n) time | O(1) space
 */
class Solution123_02 {
    public int maxProfit(int[] prices) {
        int profitOne0 = 0, profitOne1 = -prices[0], profitTwo0 = 0, profitTwo1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            profitTwo0 = Math.max(profitTwo0, profitTwo1 + prices[i]);
            profitTwo1 = Math.max(profitTwo1, profitOne0 - prices[i]);
            profitOne0 = Math.max(profitOne0, profitOne1 + prices[i]);
            profitOne1 = Math.max(profitOne1, -prices[i]);
        }
        return profitTwo0;
    }
}

/**
 * Past Solutions
 */

class Solution123_03 {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            // 今天做了事情 | 今天没做事情
            buy1 = Math.max(-prices[i], buy1);
            sell1 = Math.max(buy1 + prices[i], sell1);
            buy2 = Math.max(sell1 - prices[i], buy2);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }

        int result = Math.max(sell1, sell2);
        return result < 0 ? 0 : result;
    }
}
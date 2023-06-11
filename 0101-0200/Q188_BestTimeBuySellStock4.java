import java.util.*;

/**
 * 动态规划
 * O(nk) time | O(nk) space
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
class Solution188_01 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][k+1][2];
        for (int t = k; t > 0; t--) {
            dp[0][t][0] = 0;
            dp[0][t][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int t = k; t > 0; t--) {
                dp[i][t][0] = Math.max(dp[i-1][t][0], dp[i-1][t][1] + prices[i]);
                dp[i][t][1] = Math.max(dp[i-1][t][1], dp[i-1][t-1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];
    }
}


/*
 * Past Solutions
 */
class Solution188_02 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, Integer.MIN_VALUE);
        buy[1] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            for (int t = 1; t <= k; t++) {
                if (t == 1) {
                    buy[t] = Math.max(-prices[i], buy[t]);
                } else {
                    buy[t] = Math.max(sell[t-1] - prices[i], buy[t]);
                }
                sell[t] = Math.max(buy[t] + prices[i], sell[t]);
            }
        }
        
        
        int result = 0;
        for (int profit: sell) {
            if (profit > result) {
                result = profit;
            }
        }
        
        return result;
    }
}
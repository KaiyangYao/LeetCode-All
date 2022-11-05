import java.util.*;

/*
 * O(nk) time | O(1) space
 *
 * 2022/11/05
 */
class Solution188 {
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
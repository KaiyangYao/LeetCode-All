/*
 * O(n) time | O(1) space
 * 
 * 2022/11/05
 */
class Solution123 {
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
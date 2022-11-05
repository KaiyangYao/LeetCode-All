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
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        
        return max;
    }
}

/*
 * DP with optimized space
 * O(n) time | O(1) space
 * 
 * 2022/11/05
 */
class Solution122V2 {
    public int maxProfit(int[] prices) {
        int own = -prices[0];
        int not = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // 今天持有 = 昨天没持有+今天买进 or 昨天就持有今天什么都不干
            own = Math.max(not - prices[i], own);
            // 今天没持有 = 昨天持有+今天卖出 or 昨天就没持有今天什么都不干
            not = Math.max(own + prices[i], not);
        }
        
        return not;
    }
}
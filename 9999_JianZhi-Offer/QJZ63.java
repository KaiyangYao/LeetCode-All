/*
 * 剑指 Offer 63. 股票的最大利润
 * 
 * 简单DP
 * 
 * O(n) time, O(1) space
 * 
 * 2023/01/31
 */
class QJZ63 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
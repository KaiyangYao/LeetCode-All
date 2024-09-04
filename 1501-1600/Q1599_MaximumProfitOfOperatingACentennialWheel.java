/**
 * 模拟
 * 20240101 CN Daily
 * Solution: https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/solutions/2579733/1599-jing-ying-mo-tian-lun-de-zui-da-li-zjj5d/?envType=daily-question&envId=2024-01-01
 */

/**
 * O(n) time | O(1) space
 */
class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfitEachTime = boardingCost * 4 - runningCost;
        if (maxProfitEachTime <= 0) {
            return -1;
        }

        int maxProfit = 0, maxProfitOperations = -1, totalProfit = 0, operations = 0;
        int customersCount = 0;

        for (int num : customers) {
            customersCount += num;
            int currBoard = Math.min(customersCount, 4);
            customersCount -= currBoard;
            totalProfit += boardingCost * currBoard - runningCost;
            operations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitOperations = operations;
            }
        }

        if (customersCount > 0) {
            int fullOperations = customersCount / 4;
            totalProfit += maxProfitEachTime * fullOperations;
            operations += fullOperations;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitOperations = operations;
            }

            int remainProfit = boardingCost * (customersCount % 4) - runningCost;
            totalProfit += remainProfit;
            operations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitOperations = operations;
            }
        }
        return maxProfitOperations;
    }
}
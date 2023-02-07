/*
 * DP
 * 
 * Same as #70
 * 
 * O(n) time | O(n) space
 * 
 * 2023/02/03
 */
class Solution746_01 {
    public int minCostClimbingStairs(int[] cost) {
        // 装填: dp[i] = 到达i级台阶的最小花费
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }

        return dp[cost.length];
    }
}

// Method 2. 滚动数组
// O(n) time | O(1) space
class Solution746_02 {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int curr = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int next = Math.min(prev + cost[i-2], curr + cost[i-1]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
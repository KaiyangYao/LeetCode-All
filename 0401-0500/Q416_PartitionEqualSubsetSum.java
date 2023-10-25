/**
 * 0-1 背包 | 0-1 knapsack
 * 2023/10/02
 */

/**
 * O(n * sum) time | O(n * sum) space
 */
class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case 就是 dp[..][0] = true 和 dp[0][..] =
        // false，因为背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包。
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}

/**
 * O(n * sum) time
 * O(sum) space
 */
class Solution416_02 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int s : nums)
            sum += s;
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            // 注意这里要倒序
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
    }
}
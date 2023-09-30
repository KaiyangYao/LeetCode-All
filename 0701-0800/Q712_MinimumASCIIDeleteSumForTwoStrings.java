/**
 * String DP
 * 2023/09/27
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /**
                     * 当 s1[i−1]≠s2[j−1] 时，考虑以下两项：
                     * - 使 s1[0:i−1] 和 s2[0:j] 相同的最小 ASCII 删除和，加上删除 s1[i−1] 的 ASCII 值；
                     * - 使 s1[0:i] 和 s2[0:j−1] 相同的最小 ASCII 删除和，加上删除 s2[j−1] 的 ASCII 值。
                     */
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
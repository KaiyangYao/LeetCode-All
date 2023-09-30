/**
 * 二维DP表示一维 区间DP
 * 2023/09/28
 * 
 * Similar: Q516
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution1312 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
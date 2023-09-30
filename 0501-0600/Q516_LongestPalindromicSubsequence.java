/**
 * 二维DP表示一维 区间DP
 * 2023/09/28
 * 好题
 * 
 * Similar: Q1312
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int r = n - 1; r >= 0; r--) {
            for (int c = r; c < n; c++) {
                if (r == c) {
                    dp[r][c] = 1;
                    continue;
                }

                if (s.charAt(r) == s.charAt(c)) {
                    dp[r][c] = dp[r + 1][c - 1] + 2;
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
/**
 * DP Subsequence
 * 2023/09/26
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        // dp[i][j]: s[0-i] 包含 t[0-j] 的数量
        int[][] dp = new int[m + 1][n + 1];
        s = " " + s;
        t = " " + t;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // 任何都可以匹配t[0-0] 即 “ ”
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 不用 s[i]
                dp[i][j] = dp[i - 1][j];

                // 用 s[i]
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
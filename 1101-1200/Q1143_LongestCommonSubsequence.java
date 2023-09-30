/**
 * 字符串DP
 * 2023/09/26
 * 
 * Similar: Q72
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 不需要比较dp[i-1][j-1]，因为这两个肯定大于等于那个
                }
            }
        }
        return dp[m][n];
    }
}
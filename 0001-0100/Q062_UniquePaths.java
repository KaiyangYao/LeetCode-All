/*
 * Path DP exercise 1
 * 
 * O(m*n) time
 * O(m*n) space
 * 
 * 2023/01/31
 */
class Solution062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0 && c > 0) {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                } else if (r > 0) {
                    dp[r][c] = dp[r-1][c];
                } else if (c > 0) {
                    dp[r][c] = dp[r][c-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
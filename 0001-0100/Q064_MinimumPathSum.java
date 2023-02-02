/*
 * Path DP exercise 3
 * 
 * O(m*n) time
 * O(m*n) space
 * 
 * 2023/01/31
 */
class Solution064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0 && c > 0) {
                    dp[r][c] = grid[r][c] + Math.min(dp[r-1][c], dp[r][c-1]);
                } else if (r > 0) {  // first col
                    dp[r][c] = grid[r][c] + dp[r-1][c];
                } else if (c > 0) {  // first row
                    dp[r][c] = grid[r][c] + dp[r][c-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
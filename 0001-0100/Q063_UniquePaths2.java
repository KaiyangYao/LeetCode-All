/*
 * Path DP exercise 2
 * 
 * O(m*n) time
 * O(m*n) space
 * 
 * 2023/01/31
 */
class Solution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] != 1) {
                    if (r > 0 && c > 0) {
                        dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                    } else if (r > 0) {
                        dp[r][c] = dp[r - 1][c];
                    } else if (c > 0) {
                        dp[r][c] = dp[r][c - 1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
/*
 * 剑指 Offer 47. 礼物的最大价值
 * 
 * DP
 * 
 * O(mn) time
 * O(mn) space || O(1) space if modified on the original array
 * 
 * 2023/02/02
 */
class QJZ47 {
    /**
     * 状态定义： 设动态规划矩阵 dp，dp(i,j) 代表从棋盘的左上角开始，到达单元格 (i,j) 时能拿到礼物的最大累计价值。
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c];
                if (r == 0 && c == 0) {
                    dp[r][c] = val;
                } else if (r == 0) {
                    dp[r][c] = dp[r][c-1] + val;
                } else if (c == 0) {
                    dp[r][c] = dp[r-1][c] + val;
                } else {
                    dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]) + val;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
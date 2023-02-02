/*
 * Path DP exercise 6
 * 
 * Method 1. 正常DP
 * O(n^3) time  (Dangerous!)
 * O(n^2) space
 * 
 * 2023/01/30
 */
class Solution1289_1 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = grid[0][c];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int curr = grid[r][c];
                dp[r][c] = Integer.MAX_VALUE;
                for (int last = 0; last < n; last++) {
                    if (last != c) {
                        dp[r][c] = Math.min(dp[r][c], dp[r-1][last] + curr);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int num: dp[n-1]) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}

/**
 * Method 2: 优化DP
 * 每行只存最小值和次小值，如果最小值在同一列用不了，次小值肯定能用
 * 
 * O(n^2) time
 * O(n^2) space
 */
class Solution1289_2 {
    public int minFallingPathSum(int[][] grid) {
        int MAX = Integer.MAX_VALUE;
        int n = grid.length;
        int[][] dp = new int[n][n];
        int i1, i2;  // The index of smallest, second smallest value of each row
        i1 = i2 = -1;

        for (int c = 0; c < n; c++) {
            dp[0][c] = grid[0][c];
            if (dp[0][c] < (i1 == -1 ? MAX : dp[0][i1])) {
                i2 = i1;
                i1 = c;
            } else if (dp[0][c] < (i2 == -1 ? MAX : dp[0][i2])) {
                i2 = c;
            }
        }

        for (int r = 1; r < n; r++) {
            int ti1, ti2;
            ti1 = ti2 = -1;
            for (int c = 0; c < n; c++) {
                int curr = grid[r][c];

                if (c != i1) {
                    dp[r][c] = dp[r-1][i1] + curr;
                } else {
                    dp[r][c] = dp[r-1][i2] + curr;
                }

                if (dp[r][c] < (ti1 == -1 ? MAX : dp[r][ti1])) {
                    ti2 = ti1;
                    ti1 = c;
                } else if (dp[r][c] < (ti2 == -1 ? MAX : dp[r][ti2])) {
                    ti2 = c;
                }
            }
            i1 = ti1;
            i2 = ti2;
        }

        return dp[n-1][i1];
    }
}


/**
 * Method 3: 优化DP + 滚动DP ？
 * 每行只存最小值和次小值，如果最小值在同一列用不了，次小值肯定能用
 * 另外只存两行滚动DP，靠余数来分行
 * 
 * O(n^2) time
 * O(n) space
 */
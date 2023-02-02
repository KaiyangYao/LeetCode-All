/*
 * Path DP exercise 5
 * 
 * Method 1. 正常DP
 * O(n^2) time
 * O(n^2) space
 * 
 * 2023/01/30
 */
class Solution931_01 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int curr = matrix[r][c];
                dp[r][c] = dp[r-1][c] + curr;
                if (c - 1 >= 0) {
                    dp[r][c] = Math.min(dp[r][c], dp[r-1][c-1] + curr);
                }
                if (c + 1 < n) {
                    dp[r][c] = Math.min(dp[r][c], dp[r-1][c+1] + curr);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int num: dp[n-1]) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}

/**
 * Method 2
 * 
 * 滚动DP
 * 
 * O(n^2) time
 * O(2n) = O(n) space
 */
class Solution931_02 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[2][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int curr = matrix[r][c];
                int currRow = r % 2;
                int lastRow = (r - 1) % 2;
                dp[currRow][c] = dp[lastRow][c] + curr;
                if (c - 1 >= 0) {
                    dp[currRow][c] = Math.min(dp[currRow][c], dp[lastRow][c-1] + curr);
                }
                if (c + 1 < n) {
                    dp[currRow][c] = Math.min(dp[currRow][c], dp[lastRow][c+1] + curr);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int resultRow = (n - 1) % 2;
        for (int num: dp[resultRow]) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}

/*
 * Method 3
 * 
 * 原地修改
 * 
 * O(n^2) time
 * O(1) space
 */
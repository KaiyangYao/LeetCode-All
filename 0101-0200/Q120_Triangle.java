import java.util.*;
/*
 * Path DP exercise 4
 * 
 * Method 1.
 * O(n^2) time
 * O(n^2) space
 * 
 * 2023/01/30
 */
class Solution120_01 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 2
        // 3 4
        // 6 5 7
        // 4 1 8 3
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int r = 1; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                int val = triangle.get(r).get(c);
                if (c == 0) {
                    dp[r][c] = dp[r-1][c] + val;
                } else if (c == r) {
                    dp[r][c] = dp[r-1][r-1] + val;
                } else {
                    dp[r][c] = Math.min(
                        dp[r-1][c-1] + val,
                        dp[r-1][c] + val
                    );
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n-1][i] < result) {
                result = dp[n-1][i];
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
class Solution120_02 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 2
        // 3 4
        // 6 5 7
        // 4 1 8 3
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int r = 1; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                int val = triangle.get(r).get(c);
                int currRow = r % 2;
                int lastRow = (r - 1) % 2;
                if (c == 0) {
                    dp[currRow][c] = dp[lastRow][c] + val;
                } else if (c == r) {
                    dp[currRow][c] = dp[lastRow][r-1] + val;
                } else {
                    dp[currRow][c] = Math.min(
                        dp[lastRow][c-1] + val,
                        dp[lastRow][c] + val
                    );
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int resultRow = (n - 1) % 2;
        for (int i = 0; i < n; i++) {
            if (dp[resultRow][i] < result) {
                result = dp[resultRow][i];
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
class Solution120_03 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <= r; c++) {
                int val = triangle.get(r).get(c);
                if (c == 0) {
                    triangle.get(r).set(c, triangle.get(r-1).get(0) + val);
                } else if (c == r) {
                    triangle.get(r).set(c, triangle.get(r-1).get(r-1) + val);
                } else {
                    triangle.get(r).set(c, Math.min(
                        triangle.get(r-1).get(c-1) + val,
                        triangle.get(r-1).get(c) + val
                    ));
                }
            }
        }
        
        int result = Integer.MAX_VALUE;

        for (Integer i: triangle.get(triangle.size()-1)) {
            if (i < result) {
                result = i;
            }
        }
        return result;
    }
}
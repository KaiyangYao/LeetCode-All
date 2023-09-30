/**
 * 2D DP
 * 2023/09/28
 */

/**
 * O(mn) time | O(mn) space
 */
class Solution1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MIN_VALUE / 2;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];
                // if we choose the curr prod
                int max1 = Math.max(dp[i - 1][j - 1] + prod, prod);
                // if we don't
                int max2 = Math.max(dp[i - 1][j], dp[i][j - 1]);

                dp[i][j] = Math.max(max1, max2);
            }
        }
        return dp[m][n];
    }
}
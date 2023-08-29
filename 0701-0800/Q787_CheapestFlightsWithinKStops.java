import java.util.*;

/**
 * 2023/07/15
 * 
 * need review
 */
class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i][j]: 第 i 次中转从 src 到 j 的最短路径
        int[][] dp = new int[k+2][n];
        for (int[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < k + 2; i++) {
            dp[i][src] = 0;
        }

        for (int i = 1; i <= k + 1; i++) {
            for (int[] f : flights) {
                int x = f[0], y = f[1], cost = f[2];
                if (dp[i-1][x] == Integer.MAX_VALUE / 2) continue;
                dp[i][y] = Math.min(dp[i][y], dp[i-1][x] + cost);
            }
        }

        int ans = Integer.MAX_VALUE / 2;
        for (int t = 0; t <= k + 1; t++) {
            ans = Math.min(ans, dp[t][dst]);
        }
        
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}
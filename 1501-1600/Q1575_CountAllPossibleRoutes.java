import java.util.*;
/*
 * Path DP exercise 7
 * 
 * Memo + dfs
 * 
 * O(n * fuel) * O(n) = O(n^2 * fuel) time
 * 状态(memo数组)数量是O(n * fuel)，每个状态要O(n)次转移
 * 
 * O(n * fuel) space
 * 二维memo数组的space
 * 
 * 
 * 2023/02/01
 */

class Solution1575 {
    static final int MOD = 1000000007;
    int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new int[locations.length][fuel+1];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }

        memo[start][fuel] = 0;

        if (Math.abs(locations[finish] - locations[start]) > fuel) {
            return 0;
        }

        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int cost;
                if ((cost = Math.abs(locations[start] - locations[i])) <= fuel) {
                    memo[start][fuel] += dfs(locations, i, finish, fuel - cost);
                    memo[start][fuel] %= MOD;
                }
            }
        }

        if (start == finish) {
            memo[start][fuel] += 1;
            memo[start][fuel] %= MOD;
        }

        return memo[start][fuel];
    }


}
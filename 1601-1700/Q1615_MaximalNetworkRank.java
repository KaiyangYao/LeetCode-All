/**
 * Graph Theory (暴力枚举)
 * 
 * O(n^2) time | O(n^2) space
 * 
 * 2023/06/26
 */
class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] visited = new boolean[n][n];
        for (int[] road: roads) {
            count[road[0]]++;
            count[road[1]]++;
            visited[road[0]][road[1]] = true;
            visited[road[1]][road[0]] = true;
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currRank = count[i] + count[j] - (visited[i][j] ? 1 : 0);
                result = Math.max(result, currRank);
            }
        }

        return result;
    }
}
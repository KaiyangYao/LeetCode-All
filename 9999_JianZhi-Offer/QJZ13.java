/*
 * 剑指 Offer 13. 机器人的运动范围
 * 
 * O(m * n) time
 * O(m * n) space
 * 
 * 2023/02/07
 */
class QJZ13 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int r, int c, int m, int n, int k, int[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n || !valid(r, c, k) || visited[r][c] == 1) {
            return 0;
        }

        int count = 1;
        visited[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            count += dfs(r + directions[i][0], c + directions[i][1], m, n, k, visited);
        }

        return count;
    }

    private boolean valid(int r, int c, int k) {
        return (getSum(r) + getSum(c)) <= k;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
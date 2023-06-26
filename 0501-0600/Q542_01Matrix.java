import java.util.*;

/**
 * 多源BFS
 * 
 * 2023/06/24
 * 
 * O(mn) time | O(mn) space
 */
class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] curr = q.poll();
                int currX = curr[0], currY = curr[1];
                for (int[] d: directions) {
                    int nextX = currX + d[0];
                    int nextY = currY + d[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || mat[nextX][nextY] == 0) {
                        continue;
                    }
                    result[nextX][nextY] = level;
                    mat[nextX][nextY] = 0;
                    q.offer(new int[] {nextX, nextY});
                }
            }
            level++;
        }

        return result;
    }
}
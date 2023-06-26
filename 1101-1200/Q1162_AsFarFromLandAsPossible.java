import java.util.*;

/*
 * bfs
 * 
 * O(n^2)time
 * O(n^2) space
 * 
 * 2023/02/25
 */
class Solution1162{
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> d = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    d.add(new int[]{r, c, 0});
                }
            }
        }

        int result = -1;
        while (!d.isEmpty()) {
            int[] next = d.poll();
            int dx = next[0], dy = next[1], step = next[2];
            result = Math.max(result, step);
            for (int[] direction: directions) {
                int newX = dx + direction[0];
                int newY = dy + direction[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                d.add(new int[]{newX, newY, step + 1});
                grid[newX][newY] = step + 1;
            }
        }

        return result == 0 ? -1 : result;
    }
}
import java.util.*;

/**
 * Multi Source BFS
 * 2023/09/15
 */

/**
 * O(mn) time | O(1) space
 */
class Solution994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int numFresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    numFresh++;
                }
            }
        }

        if (numFresh == 0) {
            return 0;
        }

        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : directions) {
                    int newX = curr[0] + d[0];
                    int newY = curr[1] + d[1];
                    if (isValid(newX, newY, grid)) {
                        grid[newX][newY] = 2;
                        q.offer(new int[] { newX, newY });
                        numFresh--;
                        if (numFresh == 0) {
                            return time;
                        }
                    }
                }
            }
        }

        return numFresh > 0 ? -1 : time;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}
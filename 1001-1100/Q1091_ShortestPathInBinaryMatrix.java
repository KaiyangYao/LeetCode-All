import java.util.*;

/**
 * BFS
 * 
 * 2023/06/25
 * 
 * O(n^2) time | O(n^2) space
 */
class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        if (grid.length == 1) return 1;
        int[][] directions = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                for (int[] dir: directions) {
                    int nextX = currX + dir[0];
                    int nextY = currY + dir[1];
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 1) {
                        continue;
                    }
                    if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                        return count + 1;
                    }
                    grid[nextX][nextY] = 1;
                    q.offer(new int[] {nextX, nextY});
                }
            }
            count++;
        }

        return -1;
    }
}
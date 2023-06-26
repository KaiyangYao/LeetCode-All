import java.util.*;

/**
 * DFS + BFS
 * 
 * 2023/06/21
 * 
 * O(mn) time | O(mn) space
 */
class Solution934 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> island = new ArrayDeque<>();
        outer:for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, island);
                    break outer;
                }
            }
        }

        int step = 0;
        while (!island.isEmpty()) {
            int size = island.size();
            for (int i = 0; i < size; i++) {
                int[] next = island.poll();
                for (int[] dir: directions) {
                    int nextR = next[0]+dir[0], nextC = next[1]+dir[1];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] == 2) {
                        continue;
                    }
                    if (grid[nextR][nextC] == 0) {
                        island.offer(new int[] {nextR, nextC});
                        grid[nextR][nextC] = 2;
                    } else if (grid[nextR][nextC] == 1) {
                        return step;
                    }
                }
            }
            step++;
        }

        return step;
    }

    private void dfs(int[][] grid, int r, int c, Queue<int[]> island) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }
        island.add(new int[] {r, c});
        grid[r][c] = 2;
        for (int[] dir: directions) {
            dfs(grid, r+dir[0], c+dir[1], island);
        }
    }
}
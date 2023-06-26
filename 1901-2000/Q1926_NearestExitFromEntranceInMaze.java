import java.util.*;
/**
 * BFS
 * 
 * 2023/06/21
 * 
 * O(mn) time | O(mn) space
 */
class Solution1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        q.offer(entrance);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (checkExit(entrance, curr, m, n)) return count;
                for (int[] dir: directions) {
                    int[] next = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    if (isValid(next, maze, visited, m, n)) {
                        visited[next[0]][next[1]] = true;
                        q.offer(next);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    private boolean checkExit(int[] entrance, int[] curr, int m, int n) {
        if (curr[0] == entrance[0] && curr[1] == entrance[1]) {
            return false;
        }
        return curr[0] == 0 || curr[0] == m - 1 || curr[1] == 0 || curr[1] == n - 1;
    }

    private boolean isValid(int[] next, char[][] maze, boolean[][] visited, int m, int n) {
        int r = next[0];
        int c = next[1];
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        if (maze[r][c] == '+' || visited[r][c]) {
            return false;
        }
        return true;
    }
}
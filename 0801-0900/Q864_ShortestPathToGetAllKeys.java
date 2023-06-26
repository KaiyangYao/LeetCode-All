import java.util.*;

/**
 * BFS with bit manipulation 状态压缩
 * 
 * O(mn * 2^k) time
 * O(mn * 2^k) space
 * 
 * 2023/06/25
 */
class Solution864 {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int finalKeyMask = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[m][n][64];
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int r = 0; r < m; r++) {
            String currString = grid[r];
            for (int c = 0; c < n; c++) {
                char currChar = currString.charAt(c);
                if (currChar == '@') {
                    q.offer(new int[]{r, c, 0});
                    visited[r][c][0] = true;
                } else if (currChar >= 'a' && currChar <= 'f') {
                    finalKeyMask |= 1 << (currChar - 'a');
                }
            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                int currMask = curr[2];
                if (currMask == finalKeyMask) return step;
                for (int[] dir: directions) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    int newMask = currMask;
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                    char newCh = grid[newX].charAt(newY);
                    if (newCh == '#') continue;
                    if (newCh >= 'A' && newCh <= 'F') {
                        if ((newMask >> (newCh - 'A') & 1) == 0) continue; // 没有钥匙
                    }
                    if (newCh >= 'a' && newCh <= 'f') {
                        newMask |= 1 << (newCh - 'a');
                    }

                    if (!visited[newX][newY][newMask]) {
                        q.offer(new int[]{newX, newY, newMask});
                        visited[newX][newY][newMask] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
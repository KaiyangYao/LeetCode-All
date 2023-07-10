import java.util.*;

/**
 * BFS
 */

/**
 * O(n) time | O(n) space
 */
class Solution1197 {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] directions = new int[][] {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == x && curr[1] == y) {
                    return count;
                }
                for (int[] dir: directions) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    if (!visited.contains(newX + "," + newY) && (newX >= -1 && newY >= -1)) {
                        visited.add(newX + "," + newY);
                        q.offer(new int[] {newX, newY});
                    }
                }
            }
            count++;
        }

        return count;
    }
}
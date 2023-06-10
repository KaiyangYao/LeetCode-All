import java.util.*;

/*
 * BFS / DFS
 * 
 * O(mn) time | O(mn) space
 * 
 * 2023/02/09
 * 
 * #505: TheMaze 2
 */

 // DFS
class Solution490_01 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, int[][] visited) {
        int x1 = start[0];
        int y1 = start[1];
        int x2 = destination[0];
        int y2 = destination[1];
        if (visited[x1][y1] == 1 ) {
            return false;
        }
        if (x1 == x2 && y1 == y2) {
            return true;
        }

        visited[x1][y1] = 1;

        int up = x1 - 1;
        while (up >= 0 && maze[up][y1] == 0) {
            up--;
        }

        int right = y1 + 1;
        while (right < maze[0].length && maze[x1][right] == 0) {
            right++;
        }

        int down = x1 + 1;
        while (down < maze.length && maze[down][y1] == 0) {
            down++;
        }

        int left = y1 - 1;
        while (left >= 0 && maze[x1][left] == 0) {
            left--;
        }

        return dfs(maze, new int[]{up + 1, y1}, destination, visited)
        || dfs(maze, new int[]{x1, right - 1}, destination, visited)
        || dfs(maze, new int[]{down - 1, y1}, destination, visited)
        || dfs(maze, new int[]{x1, left + 1}, destination, visited);
    }
}

// BFS
class Solution490_02 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visited = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            visited[currX][currY] = 1;
            if (currX == destination[0] && currY == destination[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currX + directions[i][0];
                int newY = currY + directions[i][1];
                while (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0) {
                    newX += directions[i][0];
                    newY += directions[i][1];
                }
                //结束 while 时，说明当前点是墙壁或者超出边界，往回走一格
                newX -= directions[i][0];
                newY -= directions[i][1];
                if (visited[newX][newY] == 0) {
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return false;
    }
}
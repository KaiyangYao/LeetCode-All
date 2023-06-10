import java.util.*;
/*
 * BFS
 * 
 * O(MN max(M, N)) time
 * O(MN) space
 * 
 * 2023/02/09
 * 
 * #490: TheMaze 1
 * 
 * 错误解法：bfs，visited，第一次找出口return
 * 为什么呢？仔细想想是因为我们BFS的层次遍历，其实是每撞一次墙算一层，但是撞墙次数少的路径不一定总步数少，因为一次撞墙可以走多步。
 */
class Solution505{
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row: distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dfs(maze, start, destination, distance);
    }

    private int dfs(int[][] maze, int[] start, int[] destination, int[][] distance) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], 0});
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            for (int[] direction: directions) {
                int newX = currX + direction[0];
                int newY = currY + direction[1];
                int count = 0;
                while (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == 0) {
                    newX += direction[0];
                    newY += direction[1];
                    count++;
                }
                newX -= direction[0];
                newY -= direction[1];

                if (distance[currX][currY] + count < distance[newX][newY]) {
                    distance[newX][newY] = distance[currX][currY] + count;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
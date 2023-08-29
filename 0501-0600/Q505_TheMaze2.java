import java.util.*;
/*
 * Dijkstra
 * 
 * O(MN max(M, N)) time
 * O(MN) space
 * 
 * 2023/02/09
 * 
 * #490: TheMaze 1
 */

 /** 
  * 标准Dijkstra做法!!!
  */
class Solution505_01 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        distance[start[0]][start[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { start[0], start[1], 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int[] dir : directions) {
                int currX = curr[0], currY = curr[1];
                int count = 0;
                int deltaX = dir[0], deltaY = dir[1];
                while (currX + deltaX >= 0 && currX + deltaX < m && currY + deltaY >= 0 && currY + deltaY < n
                        && maze[currX + deltaX][currY + deltaY] == 0) {
                    currX += deltaX;
                    currY += deltaY;
                    count++;
                }

                if (currX == destination[0] && currY == destination[1]) {
                    return curr[2] + count;
                }

                if ((curr[2] + count) < distance[currX][currY]) {
                    distance[currX][currY] = curr[2] + count;
                    pq.offer(new int[] { currX, currY, curr[2] + count });
                }
            }
        }

        return -1;
    }
}

/*
 * 错误解法：bfs，visited，第一次找出口return
 * 如果第一次找出口return需要用前面的priority queue
 * 为什么呢？仔细想想是因为我们BFS的层次遍历，其实是每撞一次墙算一层，但是撞墙次数少的路径不一定总步数少，因为一次撞墙可以走多步。
 */
class Solution505_02 {
    int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return bfs(maze, start, destination, distance);
    }

    private int bfs(int[][] maze, int[] start, int[] destination, int[][] distance) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { start[0], start[1], 0 });
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int[] direction : directions) {
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
                    queue.offer(new int[] { newX, newY });
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
                : distance[destination[0]][destination[1]];
    }
}
import java.util.*;

/**
 * 建立 adjacency matric + BFS
 * 
 * O(?) time | O(n^2) space
 */
class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];
        for (int[] e: edges) {
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            int[] neighbors = graph[curr];
            for (int i = 0; i < neighbors.length; i++) {
                if (neighbors[i] == 0 || i == curr) continue;
                if (visited[i]) return false;
                visited[i] = true;
                q.offer(i);
                graph[curr][i] = 0;
                graph[i][curr] = 0;
            }
        }

        for (boolean v: visited) {
            // Some nodes are not visited. It's a forest, not a tree
            if (!v) return false;
        }

        return true;
    }
}
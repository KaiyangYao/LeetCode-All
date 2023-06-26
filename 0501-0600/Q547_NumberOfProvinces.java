import java.util.*;

/**
 * Graph
 * 
 * 2023/06/13
 */


/**
 * DFS
 * 
 * O(n^2) time | O(n) space
 */
class Solution547_01 {
    public int findCircleNum(int[][] isConnected) {
        int numCities = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[numCities];
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, numCities, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int numCities, int currCity) {
        for (int j = 0; j < numCities; j++) {
            if (!visited[j] && isConnected[currCity][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, numCities, j);
            }
        }
    }
}

/**
 * BFS
 * 
 * O(n^2) time | O(n) space
 */
class Solution547_02 {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> queue = new ArrayDeque<>();
        int province = 0;
        int numCities = isConnected.length;
        boolean[] visited = new boolean[numCities];

        for (int i = 0; i < numCities; i++) {
            if (visited[i]) {
                continue;
            }
            queue.offer(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;
                for (int j = 0; j < numCities; j++) {
                    if (!visited[j] && isConnected[curr][j] == 1) {
                        queue.offer(j);
                    }
                }
            }
            province++;
        }

        return province;
    }
}
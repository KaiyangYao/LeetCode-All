import java.util.*;

/**
 * Graph
 * 
 * 2023/06/21
 * 
 * O(n) time | O(n) space
 */
class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] x: connections) {
            graph[x[0]].add(new int[] {x[1], 1});
            graph[x[1]].add(new int[] {x[0], 0});
        }

        int result = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            for (int[] next: graph[curr]) {
                if (visited[next[0]]) continue;
                visited[next[0]] = true;
                q.offer(next[0]);
                result += next[1];
            }
        }

        return result;
    }
}
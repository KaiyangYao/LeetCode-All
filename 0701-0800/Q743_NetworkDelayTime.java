import java.util.*;

/**
 * Dijkstra's 模板题!!
 * 
 * 2023/07/13 
 */

 /**
  * O(m log m) time | O(n + m) space
  */
class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        for (int[] g : graph) {
            Arrays.fill(g, -1);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            graph[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {k - 1, 0}); 
        while (! pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], weight = curr[1];
            for (int i = 0; i < n; i++) {
                int newWeight = weight + graph[currNode][i];
                if (graph[currNode][i] != -1 && newWeight < dist[i]) {
                    dist[i] = weight + graph[currNode][i];
                    pq.offer(new int[] {i, newWeight});
                }
            }
        }

        int max = 0;
        for (int x : dist) {
            if (x > max) {
                max = x;
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
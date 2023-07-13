import java.util.*;

/**
 * 2023/07/11
 * 
 * Kruskal + Minimum Spanning Tree + Priority Queue + Class
 */

 /**
  * O(n^2 log(n)) time | O(n^2) space
  */
class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;

        UnionFind uf = new UnionFind(points.length);
        PriorityQueue<Edge> pq = new PriorityQueue<>(n * (n - 1) / 2, (a, b) -> Integer.compare(a.weight, b.weight));

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] x = points[i];
                int[] y = points[j];
                Edge e = new Edge(i, j, getDistance(x, y));
                pq.add(e);
            }
        }

        int minWeight = 0;
        while (n > 1) {
            Edge curr = pq.poll();
            if (!uf.isConnected(curr.start, curr.end)) {
                uf.union(curr.start, curr.end);
                minWeight += curr.weight;
                n--;
            }
        }

        return minWeight;
    }

    private int getDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    private class Edge {
        int start;
        int end;
        int weight;

        public Edge(int startIndex, int endIndex, int weight) {
            this.start = startIndex;
            this.end = endIndex;
            this.weight = weight;
        }
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = parent[rootY];
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
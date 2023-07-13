import java.util.*;

/**
 * 2023/07/11
 * 
 * Kruskal + Minimum Spanning Tree
 */

class Solution1135 {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n + 1);
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        int count = 0;
        int sum = 0;
        for (int i = 0; i < connections.length; i++) {
            int[] curr = connections[i];
            if (!uf.isConnected(curr[0], curr[1])) {
                uf.union(curr[0], curr[1]);
                count++;
                sum += curr[2];
                if (count == n - 1) {
                    return sum;
                }
            }
        }

        return -1;
    }

    private class UnionFind {
        int[] parents;
        
        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parents[rootX] = parents[rootY];
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
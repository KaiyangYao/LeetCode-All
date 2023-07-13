import java.util.*;

/**
 * 2023/07/11
 * 
 * Kruskal + Minimum Spanning Tree
 */

/**
 * 做法: 超级水源!!!
 * O(n+e log(n+e)) time (排序)
 * O((n+e)) space  (并查集的数组)
 */
class Solution1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < pipes.length; i++) {
            list.add(pipes[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(new int[] { 0, i + 1, wells[i] });
        }
        list.sort((a, b) -> Integer.compare(a[2], b[2]));

        int minCost = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] curr = list.get(i);
            if (!uf.isConnected(curr[0], curr[1])) {
                uf.union(curr[0], curr[1]);
                minCost += curr[2];
                count++;
                if (count == n)
                    break;
            }
        }

        return minCost;
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
/**
 * Union Find (变体: 一边isConnected 一边union)
 * 
 * 2023/06/26
 */

/**
 * O(n logn) time | O(n) space
 */

/**
 * 可以通过并查集寻找附加的边。初始时，每个节点都属于不同的连通分量。遍历每一条边，判断这条边连接的两个顶点是否属于相同的连通分量。
 * 
 * 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，因此当前的边不会导致环出现，合并这两个顶点的连通分量。
 * 
 * 如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，将当前的边作为答案返回。
 */
class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        /**
         * 如果有多个答案，则返回数组 edges 中最后出现的边?
         * 
         * 遍历edges数组本身就是构建图的过程 当遇到一条边的两个点连通时 说明有另外一条路径连接了这两个点 如果再加上这条边就会变成环
         * 然后这条边刚好是数组中组成这个环的最后一条边 满足最后出现的边这个条件
         */
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                return new int[] { edge[0], edge[1] };
            }
            uf.union(edge[0], edge[1]);
        }

        return new int[] { 0 };
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
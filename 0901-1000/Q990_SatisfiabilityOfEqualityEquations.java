/**
 * Union Find 模板题
 * 
 * 2023/06/26
 */

 /**
  * C = 26
  * O(n + ClogC) time | O(C) space
  */
class Solution990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for (String s: equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        for (String s: equations) {
            if (s.charAt(1) == '!') {
                if (uf.isConnected(s.charAt(0) - 'a', s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 1; i < n; i++) {
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
            parent[rootX] = parent[rootY];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

}


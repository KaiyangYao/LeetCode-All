/**
 * Union Find (每个String看成一个数)
 * 
 * 2023/06/27
 */

 /**
  * O(n^2 L + nlogn) time
  * O(n) space
  * 
  * n: num Strings
  */
class Solution839 {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFound uf = new UnionFound(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSame(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getGroup();
    }

    private boolean isSame(String x, String y) {
        int diffCount = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 2) return false;
        }
        return true;
    }

    private class UnionFound {
        private int[] parent;

        public UnionFound(int n) {
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
            parent[rootY] = rootX;
        }

        public int getGroup() {
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }
}
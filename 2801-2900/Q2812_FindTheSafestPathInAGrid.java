import java.util.*;

/**
 * Multisource BFS + Union Find
 * 2023/09/30
 */
class Solution2812 {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int start = 0;
        int end = (n-1) * n + (n-1);
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dis = new int[n][n];
        UnionFind uf = new UnionFind(n*n);
        Queue<int[]> q = new ArrayDeque<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[] {i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<int[]> currGroup = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                currGroup.add(curr);
                for (int[] d : directions) {
                    int newX = curr[0] + d[0];
                    int newY = curr[1] + d[1];
                    if (!isValid(newX, newY, n) || dis[newX][newY] >= 0) {
                        continue;
                    }
                    dis[newX][newY] = step + 1;
                    q.offer(new int[] {newX, newY});
                }
            }
            map.put(step, currGroup);

            step++;
        }

        for (int i = step - 1; i > 0; i--) {
            List<int[]> currGroup = map.get(i);
            
            for (int[] x : currGroup) {
                for (int[] d : directions) {
                    int newX = x[0] + d[0];
                    int newY = x[1] + d[1];
                    if (isValid(newX, newY, n) && dis[newX][newY] >= i) {
                        uf.union(x[0] * n + x[1], newX * n + newY);
                    }
                    if (uf.isConnected(start, end)) {
                        return i;
                    }
                }
            }
            System.out.println();
        }

        return 0;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (parent[x] != x) {
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
import java.util.*;

/**
 * Tree Diameter
 * 2023/11/06
 */

/*
 * O(n) time | O(n) space
 */
class Solution1245 {
    int ans;
    boolean[] visited;
    List<List<Integer>> tree;

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }

        ans = 0;
        tree = new ArrayList<>();
        visited = new boolean[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        visited[edges[0][0]] = true;
        dfs(edges[0][0]);
        return ans - 1;
    }

    private int dfs(int root) {
        List<Integer> neighbors = tree.get(root);
        int firstL = 0, secondL = 0;
        for (int n : neighbors) {
            if (visited[n]) {
                continue;
            }
            visited[root] = true;
            int currCount = dfs(n);
            if (currCount > firstL) {
                secondL = firstL;
                firstL = currCount;
            } else if (currCount > secondL) {
                secondL = currCount;
            }
        }

        ans = Math.max(ans, firstL + secondL + 1);
        return firstL + 1;
    }
}
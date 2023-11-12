import java.util.*;

/**
 * House Robber3：树形DP
 * 2023/11/09
 */

/**
 * O(n) time | O(n) space
 */
class Solution2646 {
    private List<List<Integer>> tree;
    private int[] price, count;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        this.price = price;
        count = new int[n];
        for (int[] trip : trips) {
            addPath(trip[0], -1, trip[1]);
        }

        int[] ans = dfs(0, -1);
        return Math.min(ans[0], ans[1]);
    }

    private boolean addPath(int start, int father, int end) {
        if (start == end) {
            count[start]++;
            return true;
        }
        for (int neighbor : tree.get(start)) {
            if (neighbor != father && addPath(neighbor, start, end)) {
                count[start]++;
                return true;
            }
        }
        return false;
    }

    private int[] dfs(int node, int father) {
        int notHalf = price[node] * count[node];
        int half = notHalf / 2;
        for (int neighbor : tree.get(node)) {
            if (neighbor != father) {
                int[] curr = dfs(neighbor, node);
                notHalf += Math.min(curr[0], curr[1]);
                half += curr[0];
            }
        }
        return new int[] { notHalf, half };
    }
}
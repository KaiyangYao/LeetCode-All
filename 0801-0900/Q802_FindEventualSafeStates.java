import java.util.*;
/**
 * Graph
 * 
 * Missing: 拓扑排序 Solution
 * 
 * 2023/06/13
 */

/**
 * DFS + 涂色
 * 
 * O(n + m) time  (其中 n 是图中的点数，m 是图中的边数)
 * O(n) space color数组，递归栈的开销都是n
 */
class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, color, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSafe(int[][] graph, int[] color, int curr) {
        if (color[curr] > 0) {
            return color[curr] == 2;
        }

        color[curr] = 1;
        for (int x: graph[curr]) {
            if (!isSafe(graph, color, x)) {
                return false;
            }
        }
        color[curr] = 2;
        return true;
    }
}
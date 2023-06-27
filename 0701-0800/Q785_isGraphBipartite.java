/**
 * Graph Theory (Color Simulation)
 * DFS/BFS 变体!!
 * 
 * O(m+n) time | O(n) space
 * n: 点数， m: 边数
 * 
 * 2023/06/26
 */
class Solution785 {
    boolean valid = true;
    int color[];

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == 0) {
                doColor(i, graph, 1);
            }
        }

        return valid;
    }

    private void doColor(int i, int[][] graph, int currColor) {
        color[i] = currColor;
        for (int neighbor: graph[i]) {
            if (color[neighbor] == 0) {
                doColor(neighbor, graph, currColor == 1 ? 2 : 1);
                if (!valid) {
                    return;
                }
            } else {
                if (color[neighbor] == currColor) {
                    valid = false;
                    return;
                }
            }
        }
    }
}
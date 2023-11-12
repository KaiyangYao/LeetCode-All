import java.util.*;

/**
 * 树形DP!
 * 周赛370
 * 
 * 2023/11/08
 */

/**
 * O(n) time | O(n) space
 */
class Solution2925 {
    List<List<Integer>> tree;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        tree = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        long totalValue = 0;
        for (int x : values) {
            totalValue += x;
        }

        return totalValue - dfs(0, -1, values);
    }

    private long dfs(int node, int father, int[] values) {
        // 如果是叶子，到这一步说明我们没有损失上面的所有节点。那么这个节点必须损失
        // 细节: 如果 树是 o - o - xxx 开始，最开始的根节点会被当作叶子节点，就不往下递归了。所以要特殊判断一下
        if (node != 0 && tree.get(node).size() == 1) {
            return values[node];
        }

        // 损失根节点: 不把根节点加入答案中；另外如果损失了根节点，我们可以选择所有的儿子
        long lossNotSelected = values[node];

        // 不损失根节点，算出所有儿子损失的和
        long lossSelected = 0;
        for (int neighbor : tree.get(node)) {
            if (neighbor != father) {
                lossSelected += dfs(neighbor, node, values);
            }
        }

        return Math.min(lossNotSelected, lossSelected);
    }
}
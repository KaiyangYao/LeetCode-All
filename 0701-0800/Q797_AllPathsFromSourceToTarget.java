import java.util.*;

/**
 * Graph (DFS)
 * 
 * 2023/06/21
 * 
 * 时间复杂度：共有 n 个节点，每个节点有选和不选两种决策，总的方案数最多 2^n，对于每个方案最坏情况需要 O(n) 的复杂度进行拷贝并添加到结果集。
 * 整体复杂度为 O(n * 2^n)
 * 空间复杂度：最多有 2^n 种方案，每个方案最多有 n 个元素。整体复杂度为 O(n * 2^n)
 */
class Solution797 {
    int n;
    int[][] g;
    List<List<Integer>> result;
    List<Integer> curr;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        g = graph;
        result = new ArrayList<>();
        curr = new ArrayList<>();
        curr.add(0);
        dfs(0);

        return result;
    }

    private void dfs(int x) {
        if (x == n - 1) {
            // In Java, when you add an object (such as a List) to another list, you are actually adding a reference to the original object. If you were to use result.add(curr);, you would be adding a reference to the curr list directly. This means that if you modify the curr list later on (e.g., by removing elements from it), the modifications would also be reflected in the lists that have been added to result.
            // 如果用result.add(curr)，最后result是[[0],[0],[0]]，因为每个地址都指向相同的curr，curr每次加完一个数最后还会被删掉，只留下0
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i: g[x]) {
            curr.add(i);
            dfs(i);
            curr.remove(curr.size() - 1);
        }
    }
}
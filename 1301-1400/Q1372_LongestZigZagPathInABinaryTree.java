/**
 * Binary Tree DFS
 2023/09/04
 */

/**
 * O(n) time | O(1) space
 */
class Solution1372 {
    int maxCount = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxCount;
    }

    private int[] dfs(TreeNode root) {
        // int[0] == left, int[1] == right
        if (root == null) {
            return new int[] { -1, -1 };
        }
        int left = dfs(root.left)[1] + 1; // 下面的right数量 + 1
        int right = dfs(root.right)[0] + 1; // 下面的left数量 + 1
        maxCount = Math.max(maxCount, Math.max(left, right));
        return new int[] { left, right };
    }
}
/**
 * Binary Tree
 * 2023/11/06
 * 
 * Similar: Q104, Q124
 */

/**
 * O(n) time | O(n) space
 */
class Solution543 {
    int maxCount = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxCount - 1; // 最长的nodes sequence - 1
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        maxCount = Math.max(maxCount, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1; // depth (see Q104)
    }
}
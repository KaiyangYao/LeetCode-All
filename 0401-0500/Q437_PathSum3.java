/**
 * Binary Tree
 * 2023/09/03
 */

/**
 * Method 1: double DFS
 * O(n^2) time | O(n) space
 */
class Solution437 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs1(root, targetSum);
        return count;
    }

    private void dfs1(TreeNode root, long targetSum) {
        if (root == null)
            return;
        dfs2(root, targetSum);
        dfs1(root.left, targetSum);
        dfs1(root.right, targetSum);
    }

    private void dfs2(TreeNode root, long targetSum) {
        if (root == null)
            return;
        if (root.val == targetSum) {
            count++;
        }
        dfs2(root.left, targetSum - root.val);
        dfs2(root.right, targetSum - root.val);
    }
}
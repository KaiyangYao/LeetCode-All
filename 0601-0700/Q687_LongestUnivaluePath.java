/**
 * Binary Tree
 * 2023/11/06
 * 
 * Similar: Q104, Q125, Q543
 */

/**
 * O(n) time | O(n) space
 */
class Solution687 {
    int maxCount;

    public int longestUnivaluePath(TreeNode root) {
        maxCount = 0;
        dfs(root);
        return root == null ? 0 : maxCount - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftSum = (root.left != null && root.left.val == root.val) ? left : 0;
        int rightSum = (root.right != null && root.right.val == root.val) ? right : 0;
        maxCount = Math.max(maxCount, leftSum + rightSum + 1);
        return Math.max(leftSum, rightSum) + 1;
    }
}
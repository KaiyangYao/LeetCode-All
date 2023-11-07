/**
 * Binary Tree
 * 2023/11/06
 * 
 * Similar: Q543
 */

/**
 * O(n) time | O(n) space
 */
class Solution124 {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(Math.max(leftSum, rightSum) + root.val, 0);
    }
}
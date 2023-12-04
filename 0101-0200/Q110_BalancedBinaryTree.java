/**
 * Binary Tree DFS
 * 2023/11/15
 */

/**
 * O(n) time | O(n) space
 */
class Solution110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return flag;
    }

    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = check(root.left);
        int rightDepth = check(root.right);

        if (flag == false) {
            return 0; // anything is fine, we just want to return it
        }

        flag = Math.abs(leftDepth - rightDepth) <= 1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
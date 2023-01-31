/*
 * 剑指 Offer 27. 二叉树的镜像
 * 
 * Recursion
 * O(n) time, O(n) space (when tilted)
 * 
 * 2023/01/29
 * 
 * same as LeetCode Q226
 */
class QJZ27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        doMirror(root);
        return root;
    }

    private void doMirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        doMirror(root.left);
        doMirror(root.right);
    }
}
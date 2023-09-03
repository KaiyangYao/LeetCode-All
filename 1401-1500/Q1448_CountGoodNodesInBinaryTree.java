/**
 * Binary Tree
 * 2023/09/02
 */

/**
 * O(n) time | O(n) space
 */
class Solution1448 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, Integer.MIN_VALUE);
    }

    private int findGoodNodes(TreeNode root, int maxVal) {
        if (root == null)
            return 0;
        if (root.val >= maxVal) {
            return findGoodNodes(root.left, root.val) + findGoodNodes(root.right, root.val) + 1;
        } else {
            return findGoodNodes(root.left, maxVal) + findGoodNodes(root.right, maxVal);
        }
    }
}
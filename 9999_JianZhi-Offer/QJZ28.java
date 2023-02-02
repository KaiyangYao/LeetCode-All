 /*
 * 剑指 Offer 28. 对称的二叉树
 * 
 * n = #nodes
 * O(n) time
 * O(height) space (the stack length)  O(n) in the worst case
 * 
 * 2023/01/31
 * 
 * same as LeetCode Q101
 */
class QJZ28 {
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

    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }
    
    private boolean checkSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;  // Only 1 null
        return (t1.val == t2.val)
            && checkSymmetric(t1.right, t2.left)
            && checkSymmetric(t1.left, t2.right);
    }
}
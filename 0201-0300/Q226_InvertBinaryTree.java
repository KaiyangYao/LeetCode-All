/*
 * Recursion
 * 
 * O(n) time | O(n) space (when tilted)
 * 
 * 2023/01/29
 */
class Solution226_01 {
    public TreeNode invertTree(TreeNode root) {
        return doInvert(root);
    }

    private TreeNode doInvert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = doInvert(root.left);
        TreeNode right = doInvert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}


class Solution226_02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        doInvert(root);
        return root;
    }

    private void doInvert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        doInvert(root.left);
        doInvert(root.right);
    }
}
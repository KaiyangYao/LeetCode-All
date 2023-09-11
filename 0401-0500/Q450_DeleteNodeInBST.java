/**
 * BST
 * 2023/09/04
 */

/**
 * Recursion
 * O(n) time | O(1) space
 */
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode right = root.right;
                TreeNode curr = right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                curr.left = root.left;
                return right;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
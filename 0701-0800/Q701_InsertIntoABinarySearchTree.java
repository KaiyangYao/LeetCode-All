/**
 * BST
 * 2023/09/04
 */

/**
 * Solution 1: Iterative
 * O(n) time | O(1) space
 */
class Solution701_01 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode head = root;
        if (root == null)
            return new TreeNode(val);
        while (true) {
            if (root.val < val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            } else {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            }
        }
        return head;
    }
}

/**
 * Solution 2: Recursion
 * O(n) time | O(n) space
 */
class Solution701_02 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}

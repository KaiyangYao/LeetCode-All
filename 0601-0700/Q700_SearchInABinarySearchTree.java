/**
 * BST
 * 2023/09/04
 */

/**
 * Solution 1: Recursion
 * O(n) time | O(n) space (recursion stack)
 */
class Solution700_01 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.left == null && root.right == null)
            return null;
        return searchBST(root.val < val ? root.right : root.left, val);
    }
}

/**
 * Solution 2: Iterative
 * O(n) time | O(1) space
 */
class Solution700_02 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.val < val ? root.right : root.left;
        }
        return null;
    }
}
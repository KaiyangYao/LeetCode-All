/*
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * O(n) time | O(n) space
 * 
 * 2023/02/12
 */
class QJZ54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count = 0;
    int result = 0;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        dfs(root.left);
    }
}
/*
 * O(n) time | O(n) space
 * 
 * 2022/11/11
 */
class Solution098 {
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

    // V1: val < min || val > max
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val < min || node.val > max) {
            return false;
        }
        
        // 注意这里要cast to long, 要不然int最小值-1过不了
        return isValidBST(node.left, min, (long) node.val-1) && isValidBST(node.right, (long) node.val+1, max);
    }

    // V2: val <= min || val >= max
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST2(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return isValidBST2(node.left, min, node.val) && isValidBST2(node.right, node.val, max);
    }
}
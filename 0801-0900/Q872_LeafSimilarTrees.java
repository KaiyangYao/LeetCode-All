import java.util.*;

/**
 * Binary Tree
 * 2023/09/02
 */

/**
 * O(m+n) time | O(m+n) space
 */
class Solution {
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
  
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        findLeaf(root1, l1);
        findLeaf(root2, l2);
        return l1.equals(l2);
    }

    private void findLeaf(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        findLeaf(root.left, list);
        findLeaf(root.right, list);
    }
}
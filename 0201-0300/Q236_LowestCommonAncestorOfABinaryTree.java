import java.util.*;

/**
 * LCA Template
 */

/**
 * Solution 1: HashMap to store parent node
 * O(n) time | O(n) space
 */
class Solution236_01 {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        while (map.containsKey(p)) {
            p = map.get(p);
            set.add(p);
        }

        TreeNode result = null;
        while (true) {
            if (set.contains(q)) {
                result = q;
                break;
            }
            q = map.get(q);
        }

        return result;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}

/**
 * Solution 2: DFS
 * 
 * O(n) time | O(n) space
 */
class Solution236_02 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
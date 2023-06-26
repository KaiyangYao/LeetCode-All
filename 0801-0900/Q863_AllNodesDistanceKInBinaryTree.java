import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * 1. HashMap 建立parent链接
  * 2. DFS
  * 
  * 2023/06/25
  *
  * O(2n) = O(n) time | O(n) space 
  */
class Solution863 {
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParends(root);
        findAns(target, target, k);
        return result;
    }

    private void findParends(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParends(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParends(node.right);
        }
    }

    private void findAns(TreeNode curr, TreeNode from, int k) {
        if (curr == null) {
            return;
        }
        if (k == 0) {
            result.add(curr.val);
            return;
        }

        if (curr.left != from) {
            findAns(curr.left, curr, k-1);
        }
        if (curr.right != from) {
            findAns(curr.right, curr, k-1);
        }
        if (parents.get(curr.val) != from) {
            findAns(parents.get(curr.val), curr, k-1);
        }
    }
}
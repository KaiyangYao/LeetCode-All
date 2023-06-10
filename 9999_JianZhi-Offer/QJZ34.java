import java.util.*;

/*
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 
 * dfs
 * 
 * O(n) time (?)
 * O(n) space
 * 
 * Same as LeetCode #113
 * 
 * 2023/02/08
 */
class QJZ34 {
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

    List<List<Integer>> result = new ArrayList<>();
    int t;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        t = target;
        dfs(root, 0, new ArrayList<Integer>()); 
        return result;
    }

    private void dfs(TreeNode node, int currSum, List<Integer> list) {
        if (node == null) {
            return;
        }

        currSum += node.val;

        list.add(node.val);
        if (currSum == t && node.left == null && node.right == null) {
             // 注意这里要new ArrayList<>()！ 用来保存当前list的状态
             // 如果存的list，因为list最后会被清空，所以最后result里面会是一堆空的list
            result.add(new ArrayList<>(list));
        }

        dfs(node.left, currSum, list);
        dfs(node.right, currSum, list);

        list.remove(list.size() - 1);
    }
}
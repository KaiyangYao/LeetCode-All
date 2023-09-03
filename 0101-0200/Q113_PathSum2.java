import java.util.*;

/*
 * dfs
 * 
 * O(n) time (?)
 * O(n) space
 * 
 * 2023/02/07
 * 2023/09/02
 */
class Solution113 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        findPath(root, targetSum, new ArrayList<>());
        return result;
    }

    private void findPath(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            // 注意这里要new ArrayList<>()！ 用来保存当前list的状态
            // 如果存的list，因为list最后会被清空，所以最后result里面会是一堆空的list
            result.add(new ArrayList<>(list));
        }
        findPath(root.left, targetSum - root.val, list);
        findPath(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
}
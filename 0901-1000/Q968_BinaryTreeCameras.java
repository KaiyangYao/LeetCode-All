/**
 * 树形 DP
 * 2023/11/09
 */

/**
 * O(n) time | O(n) space
 */
class Solution968 {
    public int minCameraCover(TreeNode root) {
        int[] cond = dfs(root);
        return Math.min(cond[0], cond[2]);
    }

    /**
     * cond0 = install by self
     * cond1 = install by father
     * cond2 = install by children
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE / 2, 0, 0 };
        }
        int[] leftCond = dfs(root.left);
        int[] rightCond = dfs(root.right);

        int installBySelf = Math.min(Math.min(leftCond[0], leftCond[1]), leftCond[2])
                + Math.min(Math.min(rightCond[0], rightCond[1]), rightCond[2]) + 1;
        int installByFather = Math.min(leftCond[0], leftCond[2]) + Math.min(rightCond[0], rightCond[2]);
        int installByChildren = Math.min(Math.min(leftCond[0] + rightCond[2], leftCond[2] + rightCond[0]),
                leftCond[0] + rightCond[0]);

        return new int[] { installBySelf, installByFather, installByChildren };
    }
}
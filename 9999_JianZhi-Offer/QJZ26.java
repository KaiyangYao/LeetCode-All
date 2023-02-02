/*
 * 剑指 Offer 26. 树的子结构
 * 
 * O(MN) time  M = #nodes in A, N = #nodes in B
 * isSubStructure是O(M)，每次checkSub是O(N)
 * 
 * O(N) space 每次递归最多到A最后一个node，一共有M个
 * 
 * 2023/01/31
 */

class QJZ26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 先一个preorder，然后对每个node分析是不是符合B是A的substructure
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return (checkSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean checkSub(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return checkSub(A.left, B.left) && checkSub(A.right, B.right);
    }
}
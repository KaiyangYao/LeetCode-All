
/*
 * 剑指 Offer 04. 二维数组中的查找
 * 
 * O(m+n) time | O(1) space
 * 
 * same as LeetCode #240
 * 
 * 2023/01/28
 */

class QJZ04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int r = matrix.length - 1;
        int c = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r = r - 1;
            } else {
                c = c + 1;
            }
        }
        return false;
    }
}
/*
 * 缩减空间 (盛水容器) 问题
 * 
 * O(m+n) time | O(1) space
 * 
 * 2023/01/28
 * 
 * 类似: #11, #167
 */

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

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
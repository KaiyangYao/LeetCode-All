/**
 * 2023/07/06
 */

/**
 * O(m) time | O(1) space
 */
class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][mat[0].length - i - 1];
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }
}
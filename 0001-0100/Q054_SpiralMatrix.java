import java.util.*;

/**
 * 2023/07/07
 */

/**
 * O(mn) time | O(1) space
 */
class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int count = 1;
        int t = 0, l = 0, b = m - 1, r = n - 1;
        while (count <= m * n) {
            for (int i = l; i <= r && count <= m * n; i++) {
                result.add(matrix[t][i]);
                count++;
            }
            t++;
            for (int i = t; i <= b && count <= m * n; i++) {
                result.add(matrix[i][r]);
                count++;
            }
            r--;
            for (int i = r; i >= l && count <= m * n; i--) {
                result.add(matrix[b][i]);
                count++;
            }
            b--;
            for (int i = b; i >= t && count <= m * n; i--) {
                result.add(matrix[i][l]);
                count++;
            }
            l++;
        }

        return result;
    }
}
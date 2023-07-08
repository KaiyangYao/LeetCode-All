/**
 * So Elegant!
 * 
 * 2023/07/06
 */

 /**
  * O(n^2) time | O(1) space
  */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0, t = 0, b = n - 1, r = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int i = l; i <= r; i++) result[t][i] = count++;
            t++;

            for (int i = t; i <= b; i++) result[i][r] = count++;
            r--;

            for (int i = r; i >= l; i--) result[b][i] = count++;
            b--;

            for (int i = b; i >= t; i--) result[i][l] = count++;
            l++;
        }

        return result;
    }
}
/**
 * 2023/01/17
 */

/**
 * O(mn) time | O(1) space
 */
class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = findMax(i, j, grid);
            }
        }
        return res;
    }

    private int findMax(int r, int c, int[][] grid) {
        int max = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
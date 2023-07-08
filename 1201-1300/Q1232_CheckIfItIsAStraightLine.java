/**
 * 2023/07/07
 * 
 * 注意不要用除法
 */

/**
 * O(n) time | O(1) space
 */
class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int dy = coordinates[1][1] - coordinates[0][1];
        int dx = coordinates[1][0] - coordinates[0][0];
        for (int i = 1; i < n; i++) {
            int dyi = coordinates[i][1] - coordinates[0][1];
            int dxi = coordinates[i][0] - coordinates[0][0];
            // dy/dx = dyi/dxi
            if (dy * dxi != dyi * dx)
                return false;
        }
        return true;
    }
}
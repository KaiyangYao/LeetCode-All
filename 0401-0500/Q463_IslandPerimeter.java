/*
 * dfs
 * 
 * size(grid) = m * n
 * O(mn) time, O(mn) space
 * 
 * 2023/02/01
 */
class Solution463 {
    int[][] direction = new int[][]{{-1, 1, 0, 0}, {0, 0, -1, 1}};
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    result = dfs(grid, r, c);
                    break;
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;

        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += dfs(grid, r + direction[0][i], c + direction[1][i]);
        }

        return count;
    }
}
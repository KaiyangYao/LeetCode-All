/*
 * dfs
 * 
 * size(grid) = m * n
 * O(mn) time, O(mn) space
 * 
 * 2023/02/01
 */
class Solution200 {
    int[][] directions = new int[][]{{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + directions[0][i], c + directions[1][i]);
        }
    }
}
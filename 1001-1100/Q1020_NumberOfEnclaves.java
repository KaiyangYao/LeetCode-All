/*
 * dfs
 * 
 * O(mn)time
 * O(mn) space
 * 
 * 2023/02/25
 */
class Solution1020 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        int r = 0;
        for (int i = 0; i < 2; i++) {
            r = i * (grid.length - 1);
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                }
            }
        }

        int c = 0;
        for (int i = 0; i < 2; i++) {
            c = i * (grid[0].length - 1);
            for (r = 0; r < grid.length; r++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                }
            }
        }

        int count = 0;
        for (r = 0; r < grid.length; r++) {
            for (c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        for (int[] direction: directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
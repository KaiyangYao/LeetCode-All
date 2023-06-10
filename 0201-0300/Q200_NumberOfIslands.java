/*
 * dfs
 * 
 * size(grid) = m * n
 * O(mn) time, O(mn) space
 * 
 * 2023/02/01
 */
class Solution200 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction: directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
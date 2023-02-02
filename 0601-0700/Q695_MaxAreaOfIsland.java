/*
 * dfs (recursion)
 * 
 * size(image) = m * n
 * O(mn) time | O(mn) space for both
 * 
 * 2023/02/01
 */
class Solution695_01 {
    int[][] directions = new int[][]{{1, -1, 0, 0}, {0, 0, 1, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    result = Math.max(result, dfs(grid, r, c));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            count += dfs(grid, r + directions[0][i], c + directions[1][i]);
        }
        return count;
    }
}


// 如果不能 modify 原数组，新建一个visited array
class Solution695_02 {
    int[][] directions = new int[][]{{1, -1, 0, 0}, {0, 0, 1, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && visited[r][c] != 1) {
                    result = Math.max(result, dfs(grid, r, c, visited));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c, int[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (grid[r][c] == 0 || visited[r][c] == 1) {
            return 0;
        }

        visited[r][c] = 1;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            count += dfs(grid, r + directions[0][i], c + directions[1][i], visited);
        }
        return count;
    }
}
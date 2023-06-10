/*
 * dfs (recursion)
 * 
 * size(image) = m * n
 * O(mn) time | O(mn) space
 * 
 * 2023/02/24
 */
class Solution1254 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0 && dfs(grid, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) {
            if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) {
                return false;
            }
        }
        
        if (grid[r][c] == 1) {
            return true;
        }
        
        grid[r][c] = 1;
        boolean isValid = true;
        for (int[] direction: directions) {
            // 如果使用短路与&&的话，那么一遇到某次dfs的结果为false，短路与后面跟着的dfs就被忽略了，导致本来同属于一块岛屿的区域并没有一次遍历干净。
            isValid = isValid & dfs(grid, r + direction[0], c + direction[1]);
        }

        return isValid;
    }
}
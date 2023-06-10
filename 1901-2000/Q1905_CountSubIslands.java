/*
 * dfs
 * 
 * O(mn)time
 * O(mn) space
 * 
 * 2023/02/25
 */
class Solution1905 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int r = 0; r < grid2.length; r++) {
            for (int c = 0; c < grid2[0].length; c++) {
                if (grid2[r][c] == 1 && dfs(grid1, grid2, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || r >= grid2.length || c < 0 || c >= grid2[0].length || grid2[r][c] == 0) {
            return true;
        }

        if (grid1[r][c] == 0) {
            return false;
        }

        grid2[r][c] = 0;
        boolean result = true;
        for (int[] direction: directions) {
            result = result & dfs(grid1, grid2, r + direction[0], c + direction[1]);
        }
        return result;
    }
}   
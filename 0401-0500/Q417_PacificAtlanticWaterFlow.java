import java.util.*;

/*
 * Graph, DFS/BFS
 * 
 * 2023/06/26
 * 
 * O(mn) time | O(mn) space
 */
class Solution417 {
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific);
        }

        for (int r = 0; r < m; r++) {
            dfs(heights, r, n-1, atlantic);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, m-1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(r);
                    coord.add(c);
                    result.add(coord);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int[] dir: directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR < 0 || newR >= heights.length || newC < 0 || newC >= heights[0].length) {
                continue;
            }
            if (ocean[newR][newC]) continue;
            if (heights[newR][newC] >= heights[r][c]) {
                dfs(heights, newR, newC, ocean);
            }
        }
    }
}
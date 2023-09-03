import java.util.*;

/**
 * HashMap
 * 2023/09/01
 */

 /**
  * O(n^2) time | O(n^2) space
  */
class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length; 
        Map<String, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            StringBuffer sb = new StringBuffer();
            for (int c = 0; c < n; c++) {
                sb.append(String.valueOf(grid[r][c]));
                sb.append("%");
            }
            String row = sb.toString();
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int count = 0;
        for (int c = 0; c < n; c++) {
            StringBuffer sb = new StringBuffer();
            for (int r = 0; r < n; r++) {
                sb.append(String.valueOf(grid[r][c]));
                sb.append("%");
            }
            count += map.getOrDefault(sb.toString(), 0);
        }

        return count;
    }
}
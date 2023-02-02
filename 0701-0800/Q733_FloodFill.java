import java.util.*;

/*
 * method 1. dfs (recursion)
 * method 2. sbfs (queue)
 * 
 * size(image) = m * n
 * O(mn) time | O(mn) space for both
 * 
 * 2023/02/01
 */
class Solution733_01 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int preColor = image[sr][sc];
        if (preColor == color) return image;
        doFill(image, sr, sc, color, preColor);
        return image;
    }

    private void doFill(int[][] image, int sr, int sc, int color, int preColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        
        if (image[sr][sc] == preColor) {
            image[sr][sc] = color;
            doFill(image, sr+1, sc, color, preColor);
            doFill(image, sr-1, sc, color, preColor);
            doFill(image, sr, sc+1, color, preColor);
            doFill(image, sr, sc-1, color, preColor);
        } 
    }
}

class Solution733_02 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }
}
/*
 * backtrack (dfs)
 * 
 * 2022/11/07
 */

class Solution37V2 {
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][] box = new int[9][9];
    
    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int currNum = Integer.parseInt(String.valueOf(board[r][c])) - 1;
                int k = c/3 + r/3*3;
                
                row[r][currNum] = col[c][currNum] = box[k][currNum] = 1;
            }
        }
        
        backTrack(board, 0);
    }
    
    private boolean backTrack(char[][] board, int n) {
        if (n == 81) return true;
        int r = n / 9, c = n % 9, k = c/3 + r/3*3;
        
        if (board[r][c] != '.') {
            return backTrack(board, n+1);
        } else {
            for (int i = 0; i < 9; i++) {
                if (row[r][i] != 1 && col[c][i] != 1 && box[k][i] != 1) {
                    
                    board[r][c] = Integer.toString(i+1).charAt(0);
                    row[r][i] = col[c][i] = box[k][i] = 1;
                    
                    if (backTrack(board, n+1)) {
                        return true;
                    }
                    
                    board[r][c] = '.';
                    row[r][i] = col[c][i] = box[k][i] = 0;
                }
            }
        }
        
        return false;
    }
}


// class Solution37V1 {
//     int[][] row = new int[9][9];
//     int[][] col = new int[9][9];
//     int[][] box = new int[9][9];
    
//     public void solveSudoku(char[][] board) {
//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 if (board[r][c] == '.') continue;
//                 int currNum = Integer.parseInt(String.valueOf(board[r][c])) - 1;
//                 int k = c/3 + r/3*3;
//                 row[r][currNum] = 1;
//                 col[c][currNum] = 1;
//                 box[k][currNum] = 1;
//             }
//         }
        
//         backTrack(board, 0);
//     }
    
//     private boolean backTrack(char[][] board, int n) {
//         if (n == 81) return true;
//         int r = n / 9, c = n % 9, k = c/3 + r/3*3;
        
//         if (board[r][c] != '.') {
//             return backTrack(board, n+1);
//         } else {
//             for (int i = 0; i < 9; i++) {
//                 if (row[r][i] != 1 && col[c][i] != 1 && box[k][i] != 1) {
//                     board[r][c] = Integer.toString(i+1).charAt(0);
//                     row[r][i] = 1;
//                     col[c][i] = 1;
//                     box[c/3 + r/3*3][i] = 1;
                    
//                     if (backTrack(board, n+1)) {
//                         return true;
//                     }
                    
//                     row[r][i] = 0;
//                     col[c][i] = 0;
//                     box[c/3 + r/3*3][i] = 0;
//                 }
//             }
//             board[r][c] = '.';
//         }
        
//         return false;
//     }
// }
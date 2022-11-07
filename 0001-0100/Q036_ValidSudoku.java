/*
 * O(1) time | O(1) space  (Always 9*9 matrix)
 * 
 * 2022/11/07
 */
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] box = new int[9][10];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                
                int currNum = Integer.parseInt(String.valueOf(board[r][c]));
                
                if (rows[r][currNum] == 1 || cols[c][currNum] == 1 || box[c/3 + r/3*3][currNum] == 1) {
                    return false;    
                }
                
                rows[r][currNum] = 1;
                cols[c][currNum] = 1;
                box[c/3 + r/3*3][currNum] = 1;
            }
        }
        
        return true;
    }
}
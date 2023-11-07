/*
 * O(1) time | O(1) space  (Always 9*9 matrix)
 * 
 * 2022/11/07
 */
class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowsCheck = new int[9][9];
        int[][] colsCheck = new int[9][9];
        int[][] subboxCheck = new int[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int currNum = Integer.parseInt(String.valueOf(board[r][c])) - 1;
                
                if (! (checkValidity(rowsCheck, r, currNum) && checkValidity(colsCheck, c, currNum) && checkValidity(subboxCheck, r/3 + c/3*3, currNum)) ) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkValidity(int[][] board, int r, int c) {
        if (board[r][c] == 1) {
            return false;
        } else {
            board[r][c] = 1;
        }
        return true;
    }
}
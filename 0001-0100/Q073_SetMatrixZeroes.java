/*
 * O(m+n) time
 * O(1) space! (use first row and first col to track 0)
 * 
 * 2022/11/07
 */
class Solution073 {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        
        // 1. 扫描「首行」和「首列」记录「首行」和「首列」是否该被置零
        for (int c = 0; c < colLength; c++) {
            if (matrix[0][c] == 0) {
                firstRow = true;
                break;
            }
        }
        
        for (int r = 0; r < rowLength; r++) {
            if (matrix[r][0] == 0) {
                firstCol = true;
                break;
            }
        }
        
        // 2.1 扫描「非首行首列」的位置，如果发现零，将需要置零的信息存储到该行的「最左方」和「最上方」的格子内
        for (int r = 1; r < rowLength; r++) {
            for (int c = 1; c < colLength; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = matrix[0][c] = 0;
                }
            }
        }
        
        // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，进行「非首行首列」置零
        for (int r = 1; r < rowLength; r++) {
            for (int c = 1; c < colLength; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        // 2.3 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
        if (firstRow) {
            for (int c = 0; c < colLength; c++) {
                matrix[0][c] = 0;
            }
        }
        
        if (firstCol) {
            for (int r = 0; r < rowLength; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
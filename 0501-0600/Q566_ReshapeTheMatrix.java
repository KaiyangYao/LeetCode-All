/*
 * Map index to matrix:
 * [i/col][i%col]
 * 
 * O(rc) time | O(1) space
 * 
 * 2022/11/06
 */
class Solution566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        
        int[][] resultMatrix = new int[r][c];
        
        for (int i = 0; i < r * c; i++) {
            resultMatrix[i/c][i%c] = mat[i/n][i%n];
        }
        
        return resultMatrix;
    }
}
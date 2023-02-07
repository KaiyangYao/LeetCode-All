/*
 * Two Binary Search
 * 
 * O(log(m) + log(n)) = O(log(mn)) time
 * O(1) space
 * 
 * 2022/11/07
 * 
 * Alternative solutions: 
 * coordinates moving (O(m+n) time in worse case, O(1) in best case)
 * https://leetcode.cn/problems/search-a-2d-matrix/solutions/688381/zuo-biao-zhou-fa-er-wei-shu-zu-zhong-de-nxfc8/
 */
class Solution074_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rStart = 0;
        int rEnd = m - 1;
        int rMid = (rStart + rEnd) / 2;
        
        
        while (rStart <= rEnd) {
            rMid = (rStart + rEnd) / 2;
            if (matrix[rMid][0] > target) {
                rEnd = rMid - 1;
            } else if (matrix[rMid][n-1] < target) {
                rStart = rMid + 1;
            } else {
                break;
            }
        }
        
        int cStart = 0;
        int cEnd = n - 1;
        int cMid;        
        
        while (cStart <= cEnd) {
            cMid = (cStart + cEnd) / 2;
            if (matrix[rMid][cMid] == target) {
                return true;
            } else if (matrix[rMid][cMid] > target) {
                cEnd = cMid - 1;
            } else {
                cStart = cMid + 1;
            }
        }
        
        return false;
    }
}

/*
 * O(m+n) time | O(1) space
 */
class Solution074_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }
}
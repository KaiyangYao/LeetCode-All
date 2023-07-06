import java.util.*;

/**
 * Sort
 * 
 * 2023/07/04 CN Daily
 */

/**
 * O(m nlogn + mn) = O(m nlogn) time [m * 排序]
 * O(m logn) space
 */
class Solution2679 {
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }

        int result = 0;
        for (int c = 0; c < nums[0].length; c++) {
            int max = nums[0][c];
            for (int r = 0; r < nums.length; r++) {
                max = Math.max(max, nums[r][c]);
            }
            result += max;
        }

        return result;
    }
}
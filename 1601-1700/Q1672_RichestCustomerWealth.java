/**
 * 2023/07/06
 */

/**
 * O(mn) time | O(1) space
 */
class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] x : accounts) {
            int sum = 0;
            for (int y : x) {
                sum += y;
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
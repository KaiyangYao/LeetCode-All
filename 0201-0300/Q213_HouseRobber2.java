/**
 * DP
 * 2023/11/07
 */

/**
 * O(n) time | O(1) space
 * 
 * 环形: 选第一个偷 + doRob (2, n-1) vs. 不选第一个偷 + doRob (1, n-1)
 */
class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + doRob(2, n - 2, nums), doRob(1, n - 1, nums));
    }

    private int doRob(int start, int end, int[] nums) {
        int p1 = 0, p2 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(p2, p1 + nums[i]);
            p1 = p2;
            p2 = curr;
        }
        return p2;
    }
}
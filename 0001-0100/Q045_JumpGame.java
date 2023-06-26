/**
 * O(n) time | O(n) space
 * 
 * 2023/06/11
 * 
 * Need Re-do!!
 */
class Solution045 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) j++;
            dp[i] = dp[j] + 1;
        }
        return dp[n-1];
    }
}
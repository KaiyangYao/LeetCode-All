/*
 * 剑指 Offer 42. 连续子数组的最大和
 * 
 * DP
 * 
 * O(n) time
 * O(1) space
 * 
 * Same as Leetcode #53
 * 
 * 2023/02/02
 */
class QJZ42 {
    /**
     * 状态定义： 设动态规划列表 dp，dp[i]代表以元素 nums[i] 为结尾的连续子数组最大和。
     * 注意nums[i]必须要算进去，这样结果才是连续子数组
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);
        }
        return maxSum;
    }
}
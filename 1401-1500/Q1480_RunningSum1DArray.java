/*
 * o(n) time | O(1) space
 * 
 * 2022/11/05, 2023/01/25
 */

class Solution1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        
        return nums;
    }
}

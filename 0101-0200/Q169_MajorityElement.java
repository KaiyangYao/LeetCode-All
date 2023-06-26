/* 
 * O(n) time | O(1) space
 * 
 * 摩尔投票法 (Boyer–Moore majority vote algorithm)
 * 或叫抵消法
 * 
 * 进阶题: #229
 * 
 * 2023/06/10
 */
class Solution169 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }

        return majority;
    }
}
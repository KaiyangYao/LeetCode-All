/**
 * 2023/07/12
 */

/**
 * O(n) time | O(1)sspace
 */
class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int maxCount = count;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
        }
        return maxCount;
    }
}
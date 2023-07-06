/**
 * 2023/07/06
 * 
 * 很好的思想!! 一次循环同时判断两个
 */

/**
 * O(n) time | O(1) space
 */
class Solution896 {
    public boolean isMonotonic(int[] nums) {
        boolean inc = true, dec = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dec = false;
            }
            if (nums[i] < nums[i - 1]) {
                inc = false;
            }
        }
        return inc || dec;
    }
}
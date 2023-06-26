/**
 * Array
 * 
 * 2023/06/11
 */

 /**
  * O(n) time | O(1) space
  */
class Solution055_01 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightMost = 0;
        boolean result = false;
        for (int i = 0; i < length; i++) {
            if (i > rightMost) break;  // Unreachable
            rightMost = Math.max(rightMost, i + nums[i]);

            if (rightMost >= length - 1) {
                result = true;
                break;
            }
        }
        return result;
    }
}
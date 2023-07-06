/**
 * 2023/07/06
 */

 /**
  * O(n) time | O(1) space
  */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = i;
                break;
            }
        }
        
        if (left == -1) return;

        int right = left + 1;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
                nums[right++] = 0;
            } else {
                right++;
            }
        }
    }
}
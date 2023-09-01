/**
 * 2023/07/06
 * 2023/08/30
 */

/**
 * O(n) time | O(1) space
 */
class Solution283_01 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < n) {
            nums[index++] = 0;
        }
    }
}

/**
 * Discarded!
 * O(n) time | O(1) space
 */
class Solution283_02 {
    public void moveZeroes(int[] nums) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = i;
                break;
            }
        }

        if (left == -1)
            return;

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
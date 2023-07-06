/**
 * Super Difficult
 * 
 * 2023/07/04
 */

/**
 * O(n) time | O(n) space
 * 
 * 3 4 1 2
 * Only 1 decrease, but won't work!
 */
class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
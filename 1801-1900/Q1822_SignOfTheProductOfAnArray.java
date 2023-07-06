/**
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution1822 {
    public int arraySign(int[] nums) {
        int negCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 1) {
                negCount++;
            }
        }
        return negCount % 2 == 0 ? 1 : -1;
    }
}
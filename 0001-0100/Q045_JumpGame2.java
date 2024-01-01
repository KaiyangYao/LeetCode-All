/**
 * O(n) time | O(1) space
 * 
 * 2023/06/11
 */
class Solution045 {
    public int jump(int[] nums) {
        int maxPos = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            if (i == end) {
                end = maxPos;
                result++;
            }
        }

        return result;
    }
}
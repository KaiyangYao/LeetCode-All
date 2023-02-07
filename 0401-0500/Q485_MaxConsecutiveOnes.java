/*
 * O(n) time | O(1) space
 * 
 * 2023/02/04
 */
class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num: nums) {
            if (num == 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count); // If nums end with 1, the last group of 1 won't be updated in the loop
        return ans;
    }
}
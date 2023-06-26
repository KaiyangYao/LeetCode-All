/* 
 * O(n) time | O(1) space
 * 
 * Similar: #26, #27
 * 
 * 2022/11/11
 */

class Solution080 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num: nums) {
            if (k < 2 || nums[k-2] != num) {
                nums[k++] = num;
            }
        }
        return k;
    }
}
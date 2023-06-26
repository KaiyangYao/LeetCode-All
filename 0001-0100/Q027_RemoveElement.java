/*
 * O(n) time | O(1) space
 * 
 * Similar: #26, #80
 * 
 * 2023/06/10
 */
class Solution027 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int num: nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }
}
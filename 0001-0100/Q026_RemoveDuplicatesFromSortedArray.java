/* 
 * O(n) time | O(1) space
 * 
 * Similar: #27, #80
 * 
 * 2022/11/11
 */
class Solution026 {
    // I love this better!
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num: nums) {
            if (k < 1 || nums[k-1] != num) {
                nums[k++] = num;
            }
        }
        
        return k;
    }

    public int removeDuplicates2(int[] nums) {
        int k = 0;
        int next;
        for (next = 1; next < nums.length; next++) {
            if (nums[next] != nums[k]) {
                nums[++k] = nums[next];
            }
        }
        
        return k+1;
    }

    
}
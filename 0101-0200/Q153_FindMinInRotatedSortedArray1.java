/*
 * Binary Search
 * 
 * O(log(n)) time | O(1) space
 * 
 * 2023/01/28
 */

class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {  // 注意这里微小变化
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
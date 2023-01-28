/*
 * O(log(n)) time | O(1) space
 * 
 * Binary Search
 * 
 * 2023/01/28
 */
class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start > nums.length - 1 || nums[start] != target) {
            return new int[] {-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1;
        return new int[] {start, end};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
 * 剑指 Offer 53-1. 在排序数组中查找数字 I
 * 
 * O(log(n)) time
 * O(1) space
 * 
 * Also at LeetCode 34
 * 
 * 2023/01/28
 */

class QJZ53_01 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;
        int rightMost, leftMost;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        rightMost = right;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        leftMost = left;

        return rightMost - leftMost + 1;
    }
}

/*
 * 剑指 Offer 53-2. 0 ~ n-1 中缺失的数字
 * 
 * O(log(n)) time
 * O(1) space
 * 
 * 2023/01/28
 */
class QJZ53_02 {
    // 分两个部分，左边是顺序部分，右边是缺失部分。
    // 如果nums[mid] == mid， 说明在右边，反之在左边
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
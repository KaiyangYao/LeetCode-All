/**
 * Binary Search
 * 2023/09/10
 */

/**
 * O(log n) time | O(1) space
 */

/**
 * 旋转排序数组可分为N1 + N2两个部分，如：[4,5,6,7,1,2,3]，N1为[4,5,6,7]，N2为[1,2,3]
 *
 * 必然满足以下两个条件：
 * 1. N1和N2都是分别递增的；
 * 2. N1中的所有元素大于N2中的所有元素;
 *
 * 以上两个条件可推出：nums[0]是N1中最小的数，即nums[0] > N2中的所有元素
 *
 * 而mid不是在N1内就是在N2内
 * 所以：如果nums[0] <= nums[mid]，即mid落在了N1内，则[0, mid]肯定是有序的
 * 否则mid落在了N2内，则[mid, n)肯定是有序的
 *
 */
// if (nums[0] <= nums[mid]) {
// // 左半边有序
// } else {
// // 右半边有序
// }
class Solution033 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
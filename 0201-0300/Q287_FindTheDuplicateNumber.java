/**
 * 2023/09/11
 */

/**
 * Solution 1: Binary Search
 * O(n logn) time | O(1) space
 */
class Solution287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }
}

/**
 * Solution 2: = Q142 环形链表找入口
 * 快慢指针
 * 
 * O(n) time | O(1) space
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];

        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p1 = 0, p2 = fast;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
}
/**
 * Binary Search
 * 2023/09/10
 */

class Solution162_01 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r + 1;
    }
}

/**
 * O(log n) time | O(1) space
 */
class Solution162_02 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                return nums[mid] > nums[right] ? mid : right;
            }
            if (mid == nums.length - 1) {
                return mid;
            }

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

class Solution162_03 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long prev = mid == 0 ? Long.MIN_VALUE : (long) nums[mid - 1];
            long curr = (long) nums[mid];
            long next = mid == n - 1 ? Long.MIN_VALUE : (long) nums[mid + 1];
            if (prev < curr && curr > next) {
                res = mid;
                break;
            } else if (prev < curr && curr < next) {
                left = mid + 1;
            } else if (prev > curr && curr > next) {
                right = mid - 1;
            } else if (prev > curr && curr < next) {
                right = mid - 1;
            }
        }

        return res;
    }
}
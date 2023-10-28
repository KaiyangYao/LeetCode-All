/*
 * O(log(n)) time | O(1) space
 * 
 * Binary Search
 * 
 * 2023/01/28
 */

// left <= right 找左右 bound 的模板!!!
class Solution034_01 {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { lowerBound(nums, target), higherBound(nums, target) };
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length && nums[left] == target ? left : -1;
    }

    private int higherBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= 0 && nums[right] == target ? right : -1;
    }
}

// Alternative method，不推荐！！！
class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start > nums.length - 1 || nums[start] != target) {
            return new int[] { -1, -1 };
        }
        int end = lowerBound(nums, target + 1) - 1;
        return new int[] { start, end };
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
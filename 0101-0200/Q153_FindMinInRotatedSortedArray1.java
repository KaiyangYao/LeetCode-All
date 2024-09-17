/*
 * Binary Search
 * 
 * O(log(n)) time | O(1) space
 * 
 * 2023/01/28
 */

/**
 * 标准 left <= right 写法
 */
class Solution153_01 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[n - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[r + 1];
    }
}

class Solution153_02 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left % nums.length];
    }
}

class Solution153_03 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int currMin = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                currMin = Math.min(currMin, nums[mid]);
                right = mid - 1;
            }
        }
        return currMin;
    }
}

class Solution153_04 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

class Solution153_05 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) { // 注意这里微小变化
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
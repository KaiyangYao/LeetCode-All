/**
 * Binary Search
 * 2023/09/11
 */

// Fake Class
class ArrayReader {
    public int get(int index) {
        return -1;
    }
}

/**
 * O(log n) time | O(1) space
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        //  确定左、右边界（如果 target < 右边界的元素，则说明二分查找的左右边界已经设置好了）
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curr = reader.get(mid);
            if (curr == target) {
                return mid;
            } else if (curr < target) {
                left = mid + 1;
            } else if (curr > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
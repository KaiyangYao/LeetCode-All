/**
 * 2023/08/29
 */

/**
 * O(n) time | O(1) space
 */
class Solution238_01 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            result[i] *= right;
        }

        return result;
    }
}

/**
 * O(n) time | O(n) space
 */
class Solution238_02 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
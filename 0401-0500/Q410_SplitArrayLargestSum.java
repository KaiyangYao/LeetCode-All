/**
 * Binary Search
 * Same as Q1011
 * 2023/10/27
 */

/**
 * O(n logn) time
 * O(1) space
 */
class Solution410 {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(int[] nums, int n, int k) {
        int count = 1;
        int total = 0;
        for (int num : nums) {
            if (total + num <= n) {
                total += num;
            } else {
                count += 1;
                total = num;
            }
        }
        return count <= k;
    }
}
/*
 * 剑指 Offer 57. 和为s的两个数字
 * 水桶盛水问题
 * 
 * Two Pointers
 * O(n) time | O(1) space
 * 
 * 2023/02/07
 */
class QJZ57 {
    public int[] twoSum(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum == target) {
                return new int[]{nums[p1], nums[p2]};
            } else if (sum < target) {
                p1++;
            } else if (sum > target) {
                p2--;
            }
        }
        return new int[]{0};
    }
}
import java.util.*;

/**
 * 2023/12/06
 */
class Solution698 {
    boolean[] numUsed;
    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        numUsed = new boolean[n];
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if (sum % k != 0 || nums[n - 1] > sum / k) {
            return false;
        }

        target = sum / k;
        return divideGroups(nums, nums.length - 1, 0, k);
    }

    private boolean divideGroups(int[] nums, int start, int currSum, int k) {
        if (k == 1)
            return true;
        if (currSum == target) {
            return divideGroups(nums, nums.length - 1, 0, k - 1);
        }

        for (int i = start; i >= 0; i--) {
            if (numUsed[i] || nums[i] > target - currSum)
                continue;
            numUsed[i] = true;
            if (divideGroups(nums, i - 1, currSum + nums[i], k)) {
                return true;
            }
            numUsed[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }

        return false;
    }
}
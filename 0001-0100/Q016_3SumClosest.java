import java.util.*;

/*
 * (和上一题一模一样)
 * Sort + Two Pointer
 * 
 * time:
 * O(log(n)) for sort, O(n^2) for loop and two pointer
 * O(n^2) overall
 * 
 * space:
 * O(log(n)) for sort
 * 
 */
class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i, j, k;
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;

        for (i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < minDiff) {
                    minDiff = Math.abs(target - sum);
                    ans = sum;
                }
                if (sum < target) {
                    j += 1;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else if (sum > target) {
                    k -= 1;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }
}
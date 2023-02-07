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
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                while (j > i + 1 && j < n && nums[j] == nums[j-1]) {
                    j++;
                }
                if (j >= k) {
                    break;
                }

                int answer = nums[i] + nums[j] + nums[k];
                if (Math.abs(answer - target) < Math.abs(result - target)) {
                    result = answer;
                }
                
                if (answer == target) {
                    return result;
                } else if (answer < target) {
                    j++;
                } else if (answer > target) {
                    k--;
                }
            }
        }
        return result;
    }
}
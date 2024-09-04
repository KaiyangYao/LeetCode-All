import java.util.*;
/*
 * Sort + Two Pointer
 * 
 * time:
 * O(log(n)) for sort, O(n^2) for the loop and two pointer
 * O(n^2) overall
 * 
 * space:
 * O(log(n)) for sort
 * 
 */

 class Solution015_01 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i, j, k;
        
        for (i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 剪枝优化
            // if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
            //     break;
            // }
            // if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
            //     continue;
            // }

            j = i + 1;
            k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j += 1;
                } else if (sum > 0) {
                    k -= 1;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j += 1;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k -= 1;
                    }
                }
            }
        }

        return ans;
    }
}

// Deprecated
class Solution015_02 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;   // 注意要先比一次才安全
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                while (j > i + 1 && j < k && nums[j] == nums[j-1]) {    // 注意要先比一次才安全
                    j++;
                }
                if (j >= k) break;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return result;
    }
}
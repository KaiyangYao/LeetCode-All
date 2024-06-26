import java.util.*;
/*
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

class Solution015 {
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
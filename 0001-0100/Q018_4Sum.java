import java.util.*;

/**
 * 2023/07/15 CN Daily
 * 
 * Two Pointer
 */

/**
 * O(n^3) time
 * O(log n) space
 */

// 20240903
class Solution018_01 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int a, b, c, d;
        List<List<Integer>> ans = new ArrayList<>();

        for (a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;

                c = b + 1;
                d = n - 1;

                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) {
                        c += 1;
                    } else if (sum > target) {
                        d -= 1;
                    } else {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c += 1;
                        d -= 1;
                        while (c < d && nums[c] == nums[c - 1]) {
                            c += 1;
                        }
                        while (d > c && nums[d] == nums[d + 1]) {
                            d -= 1;
                        }
                    }
                }
            }
        }

        return ans;
    }
}

// Deprecated
class Solution018_02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int a = 0; a < nums.length - 3; a++) {
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if ((long) nums[a] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int c = b + 1, d = nums.length - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        List<Integer> ans = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        result.add(ans);
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        c++;
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }

            }
        }

        return result;
    }
}
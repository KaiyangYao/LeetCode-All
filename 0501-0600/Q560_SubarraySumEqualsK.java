import java.util.*;

/**
 * Prefix Sum
 * 2023/09/03
 * 
 * = Q930
 * 类似 Q1248, Q974
 */

/**
 * Solution 1: Prefix Sum Array
 * O(n^2) time | O(n) space
 */
class Solution560_01 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

/**
 * Solution 2: Prefix Sum with HashMap!!
 * O(n) time | O(n) space
 * 
 * Example to try out: 1, 2, 6, 4, -1, 5   k = 3
 */
class Solution560_2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 为了可以取到只有第一位的情况
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) { // right - left = k => left = right - k
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
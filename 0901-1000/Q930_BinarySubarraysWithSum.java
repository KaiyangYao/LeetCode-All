import java.util.*;

/**
 * 好题
 * 2023/09/03
 * = Q560, Q930, Q1248, Q974
 */

/**
 * Solution 1: Prefix Sum + HashMap (= Q560, 类似 Q1248)
 * O(n) time | O(n) space
 */
class Solution930_01 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0, 1); // 为了可以取到只有第一位的情况
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - goal)) {
                count += map.get(preSum - goal);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}

/**
 * Solution 2: 高级 Sliding Window
 * O(n) time | O(1) space
 */

/**
 * 我们可以使用两个左端点 l1 和 l2，代表在给定右端点 r 的前提下满足要求的左端点集合，同时使用 s1 和 s2 分别代表两个端点到 r 这一段的和。
 */
class Solution930_02 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int s1 = 0;
        int s2 = 0;
        int count = 0;
        for (int r = 0, l1 = 0, l2 = 0; r < nums.length; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > goal) {
                s1 -= nums[l1++];
            }
            while (l2 <= r && s2 >= goal) {
                s2 -= nums[l2++];
            }
            count += l2 - l1;
        }
        return count;
    }
}
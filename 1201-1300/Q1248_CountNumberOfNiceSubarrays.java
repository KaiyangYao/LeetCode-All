import java.util.*;

/**
 * 2023/09/03
 */

/**
 * 前缀和 + HashMap，但是这次map存的不是和，是奇数的个数
 * 类似 Q560, Q930, Q974
 * O(n) time | O(n) space
 */
class Solution1248_01 {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <奇数个数，count>
        map.put(0, 1); // 为了可以取到只有第一位的情况
        int oddNum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            oddNum += nums[i] % 2 == 1 ? 1 : 0;
            if (map.containsKey(oddNum - k)) {
                count += map.get(oddNum - k);
            }
            map.put(oddNum, map.getOrDefault(oddNum, 0) + 1);
        }
        return count;
    }
}
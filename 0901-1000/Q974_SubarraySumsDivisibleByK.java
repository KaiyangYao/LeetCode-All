import java.util.*;

/**
 * Prefix Sum + HashMap
 * Similar: Q560, 930, 1248, 523
 * 2023/09/04
 */

/**
 * O(n) time | O(n) space
 * 
 * ([i..j] - [x..i]) % k == 0 如果 [x..i]和[i..j] % k 有着相同的余数！
 */
class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <除以k的商, count>
        map.put(0, 1); // 为了可以取到只有第一位的情况
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int quotient = (preSum % k + k) % k; // 负数修正，注意不可以写成(preSum + k) % k，因为这样余数可能还是负数!
            if (map.containsKey(quotient)) {
                count += map.get(quotient);
            }
            map.put(quotient, map.getOrDefault(quotient, 0) + 1);
        }
        return count;
    }
}
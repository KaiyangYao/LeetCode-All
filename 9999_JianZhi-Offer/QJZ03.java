import java.util.*;

/*
 * 剑指 Offer 03. 数组中重复的数字
 * 
 * Hashset
 * O(n) time, O(n) space
 * 
 * 2023/01/27
 */

class QJZ03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num: nums) {
            if (visited.contains(num)) {
                return num;
            }
            visited.add(num);
        }
        return -1;
    }
}
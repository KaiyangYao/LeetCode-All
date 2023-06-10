import java.util.*;
/*
 * 剑指 Offer 61. 扑克牌中的顺子
 * 
 * O(5) = O(1) time
 * O(5) = O(1) space
 * 
 * 2023/02/08
 */
class QJZ61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minNum = 14;
        int maxNum = 0;
        for (int num: nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        return maxNum - minNum < 5;
    }
}
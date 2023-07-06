import java.util.*;

/**
 * 标准滑动窗口
 * 
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int l = 0, r = 0; r < fruits.length; r++) {
            int rightFruit = fruits[r];
            map.put(rightFruit, map.getOrDefault(rightFruit, 0) + 1);
            while (map.size() > 2) {
                int leftFruit = fruits[l];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                l++;
            }
            count = Math.max(count, r - l + 1);
        }
        return count;
    }
}
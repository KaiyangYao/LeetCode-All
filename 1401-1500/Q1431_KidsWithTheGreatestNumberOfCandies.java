import java.util.*;

/**
 * 2023/08/29
 */

 /**
  * O(n) time | O(1) space
  */
class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int n = candies.length;
        int globalMax = candies[0];
        for (int i = 1; i < n; i++) {
            globalMax = candies[i] >= globalMax ? candies[i] : globalMax;
        }
        for (int i = 0; i < n; i++) {
            result.add(candies[i] + extraCandies >= globalMax);
        }
        return result;
    }
}
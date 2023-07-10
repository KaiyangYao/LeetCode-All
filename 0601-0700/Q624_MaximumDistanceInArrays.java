import java.util.*;

/**
 * 2023/07/08
 * 
 * 同时维护最大和次大
 */

 /**
  * O(n) time | O(1) space
  */
class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int max1 = Integer.MIN_VALUE, max2 = max1;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        int maxIndex = -1, minIndex = -1;
        for (int i = 0; i < arrays.size(); i++) {
            int n = arrays.get(i).size();
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(n - 1);
            if (currMin < min1) {
                min2 = min1;
                min1 = currMin;
                minIndex = i;
            } else if (currMin < min2) {
                min2 = currMin;
            }

            if (currMax > max1) {
                max2 = max1;
                max1 = currMax;
                maxIndex = i;
            } else if (currMax > max2) {
                max2 = currMax;
            }
        }

        if (maxIndex != minIndex) {
            return max1 - min1;
        }

        return Math.max(max1 - min2, max2 - min1);
    }
}
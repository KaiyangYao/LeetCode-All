import java.util.*;

/**
 * Greedy
 * 
 * 2023/07/06 CN Daily
 */

/**
 * O(sqrt(n)) time | O(1) space
 */
class Solution2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if (finalSum % 2 == 1)
            return result;
        long i = 2, sum = 0;
        while (sum + i <= finalSum) {
            sum += i;
            result.add(i);
            i += 2;
        }
        if (sum < finalSum) {
            result.remove(result.size() - 1);
            result.add(finalSum - sum + (i - 2));
        }

        return result;
    }
}
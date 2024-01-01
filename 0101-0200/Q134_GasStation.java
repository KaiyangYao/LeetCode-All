/**
 * Greedy
 * 2023/12/04
 */

/**
 * O(n) time | O(1) space
 * Total < 0 肯定不行，total > 0 的第一个位置肯定可以，因为只有uniquely一个答案
 */
class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if (sumGas < sumCost) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                start = i + 1;
                total = 0;
            }
        }

        return start;
    }
}
/**
 * Greedy
 * 2023/12/05
 */

/**
 * O(n) time
 * O(1) space
 */
class Solution1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] record = new int[3];
        out: for (int[] trip : triplets) {
            for (int i = 0; i < 3; i++) {
                if (trip[i] > target[i])
                    continue out;
            }

            for (int i = 0; i < 3; i++) {
                if (trip[i] == target[i]) {
                    record[i] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += record[i];
        }

        return sum == 3;
    }
}
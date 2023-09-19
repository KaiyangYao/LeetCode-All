/**
 * Bit operation
 * 2023/09/14
 */

/**
 * O(1) time | O(1) space
 */
class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int currA = (a & mask) >> i;
            int currB = (b & mask) >> i;
            int currC = (c & mask) >> i;
            if (currC == 0) {
                if (currA + currB == 1) {
                    count += 1;
                }
                if (currA + currB == 2) {
                    count += 2;
                }
            } else {
                if (currA + currB == 0) {
                    count += 1;
                }
            }
            mask <<= 1;
        }
        return count;
    }
}
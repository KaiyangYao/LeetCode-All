/**
 * Greedy
 * 
 * 2023/07/05 CN Daily
 */

/**
 * O(1) time | O(1) space
 */
class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes + numZeros >= k) {
            return numOnes >= k ? k : numOnes;
        } else {
            return numOnes - (k - (numOnes + numZeros));
        }
    }
}
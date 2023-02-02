/*
 * DP
 * 
 * O(n) time
 * O(1) space
 * 
 * 2023/01/31
 */
class Solution070 {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int twoStep1 = 1;
        int oneStep = 1;
        int curr;
        for (int i = 2; i <= n; i++) {
            curr = twoStep1 + oneStep;
            twoStep1 = oneStep;
            oneStep = curr;
        }
        return oneStep;
    }
}
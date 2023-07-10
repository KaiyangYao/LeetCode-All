/**
 * 2023/07/10
 */

/**
 * x^32 -> x^2 -> x^4 -> x^8 -> x^16 -> x^32
 * x^77 -> x^2 -> x^4 -> x^9 -> x^19 -> x^38 -> x^77
 */

/**
 * O(log n) time | O(log n) space
 */
class Solution050 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, N);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
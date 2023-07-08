/**
 * 2023/07/07
 */

/**
 * O(n) time | O(1) space
 */
class Solution1491 {
    public double average(int[] salary) {
        int max = salary[0], min = salary[1];
        int sum = 0;
        for (int x : salary) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            sum += x;
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
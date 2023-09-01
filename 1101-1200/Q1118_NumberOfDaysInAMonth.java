/**
 * 2023/08/29
 */

/**
 * O(1) time | O(1) space
 */
class Solution1118 {
    public int numberOfDays(int Y, int M) {
        int[] year1 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 闰年
        int[] year2 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 非闰年
        if ((Y % 100 != 0 && Y % 4 == 0) || Y % 400 == 0) {
            return year1[M - 1];
        }
        return year2[M - 1];
    }
}
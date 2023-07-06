/**
 * 2023/07/06
 * 
 * 思路: 从左往右遍历，如果右边比左边大就减去左边的
 */

/**
 * O(n) time | O(1) space
 */
class Solution013 {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = getValue(s.charAt(i));
            if (i + 1 < s.length() && getValue(s.charAt(i + 1)) > val) {
                sum -= val;
            } else {
                sum += val;
            }
        }

        return sum;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
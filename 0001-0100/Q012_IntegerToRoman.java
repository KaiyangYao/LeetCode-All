/**
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution012 {
    public String intToRoman(int num) {
        int[] value = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] notation = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        StringBuffer sb = new StringBuffer();
        for (int i = value.length - 1; i >= 0; i--) {
            while (num >= value[i]) {
                sb.append(notation[i]);
                num -= value[i];
            }

            if (num == 0)
                break;
        }

        return sb.toString();
    }
}
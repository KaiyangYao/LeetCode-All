/**
 * 2023/07/08
 * 
 * Similar: Q67, Q002
 */

/**
 * O(n) time | O(1) space
 * 
 * n = Max(len(num1), len(num2))
 */
class Solution415 {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            sb.append(String.valueOf((x1 + x2 + carry) % 10));
            carry = (x1 + x2 + carry) / 10;
            p1--;
            p2--;
        }
        if (carry != 0) {
            sb.append(String.valueOf(carry));
        }

        return sb.reverse().toString();
    }
}
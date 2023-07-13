/**
 * 2023/07/06
 * 
 * Samilar: Q415, Q002
 */

/**
 * O(n) time | O(1) space
 */
class Solution067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int extra = 0;
        for (int p1 = a.length() - 1, p2 = b.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            int sum = extra;
            if (p1 >= 0) {
                sum += a.charAt(p1) - '0';
            }
            if (p2 >= 0) {
                sum += b.charAt(p2) - '0';
            }
            sb.append(sum % 2 == 0 ? "0" : "1");
            extra = sum / 2;
        }
        if (extra == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
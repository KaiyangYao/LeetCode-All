/**
 * 2023/07/08
 */

/**
 * 乘法思想
 * O(mn) time | O(m+n) space
 */
class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for (int i = n - 1; i >= 0; i--) {
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        int index = arr[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < m + n; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}

/**
 * 加法思想
 * O(mn + n^2) time | O(m + n) space
 */
class Solution043_02 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();

        for (int i = n - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j > i; j--) {
                sb.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                sb.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }

            ans = addStrings(ans, sb.reverse().toString());
        }

        return ans;
    }

    // From Q415
    private String addStrings(String num1, String num2) {
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
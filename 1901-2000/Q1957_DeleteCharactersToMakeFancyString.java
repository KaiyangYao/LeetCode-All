/**
 * 分组循环
 * 2023/11/29
 */

/**
 * O(n) time
 * O(1) space
 */

class Solution1957 {
    public String makeFancyString(String s) {
        int n = s.length();
        int l = 0;
        StringBuilder result = new StringBuilder();
        while (l < n) {
            int r;
            for (r = l + 1; r < n; r++) {
                if (s.charAt(r) != s.charAt(l)) {
                    break;
                }
            }

            int count = 0;
            while (l < r) {
                result.append(s.charAt(l));
                count++;
                l++;
                if (count == 2) {
                    break;
                }
            }

            l = r;
        }

        return result.toString();
    }
}
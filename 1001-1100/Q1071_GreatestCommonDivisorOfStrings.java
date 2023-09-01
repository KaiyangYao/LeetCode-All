/**
 * 2023/08/29
 */
class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        for (int i = Math.min(m, n); i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    private boolean check(String X, String str) {
        int times = str.length() / X.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(X);
        }
        return sb.toString().equals(str);
    }
}
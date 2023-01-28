/*
 * 剑指 Offer 58. 左旋转字符串
 * 
 * O(n) time, O(n) space
 * 
 * Advaced approach: mod
 * 
 * 2023/01/27
 */
class QJZ58 {
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

    // Use modulo! So nice
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
}

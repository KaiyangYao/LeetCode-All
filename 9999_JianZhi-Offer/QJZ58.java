/*
 * 剑指 Offer 58. 
 * 
 * I. 翻转单词顺序
 * 双指针
 * O(n) time, O(n) space
 * Same as Leetcode #151
 * 
 * 
 * II. 左旋转字符串 (用Modulo)
 * O(n) time, O(n) space
 * 
 * 2023/01/27, 2023/02/07
 */

class QJZ58_Q1 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i+1, j+1));
            sb.append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}


class QJZ58_Q2_01 {
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

class QJZ58_Q2_02 {
    public String reverseLeftWords2(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for (int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }
}

class QJZ58_Q2_03 {
    // Use modulo! So nice
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
}

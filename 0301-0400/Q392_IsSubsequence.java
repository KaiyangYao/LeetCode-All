/*
 * Two pointer
 * 
 * O(m+n) time (m = len(s), n = len(t))
 * O(1) space
 * 
 * 2022/11/15, 2023/01/25
 */
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        int lenS = s.length();
        int lenT = t.length();
        
        while (p1 < lenS && p2 < lenT) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        
        return p1 == lenS;
    }
}
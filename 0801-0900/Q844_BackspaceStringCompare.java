/*
 * Two Pointers
 * 
 * O(m + n) time | O(1) space
 * 
 * 2023/02/06
 */
class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (s.charAt(p1) == '#') {
                    skipS++;
                    p1--;
                } else if (skipS > 0) {
                    p1--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (p2 >= 0) {
                if (t.charAt(p2) == '#') {
                    skipT++;
                    p2--;
                } else if (skipT > 0) {
                    p2--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (p1 >= 0 && p2 >= 0) {
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                }
            } else {
                if (p1 >= 0 || p2 >= 0) {
                    return false;
                }
            }

            p1--;
            p2--;
        }

        return true;
    }
}
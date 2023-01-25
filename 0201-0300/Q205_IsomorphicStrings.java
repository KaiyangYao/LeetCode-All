import java.util.*;

/*
 * O(n) time  (the length of either string)
 * O(x) space (the number of diverse characters. [to be stored in a hashmap])
 * 
 * 2022/11/05, 2023/01/25
 */
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> toT = new HashMap<>();
        Map<Character, Character> toS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            
            if (!toT.containsKey(x)) {
                toT.put(x, y);
            }
            if (!toS.containsKey(y)) {
                toS.put(y, x);
            }
            
            if (toT.get(x) != y || toS.get(y) != x) {
                return false;
            }
        }
        
        return true;
    }
}
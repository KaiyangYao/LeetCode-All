import java.util.*;

/*
 * Stack
 * 
 * O(n) time | O(n) space
 * isValid: with HashMap
 * isValid2: without HashMap
 * 
 * 2022/11/11
 */
class Solution020 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            } else {
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')') {
                    if (stack.peek() != '(') return false;
                    stack.pop();
                }
                if (c == ']') {
                    if (stack.peek() != '[') return false;
                    stack.pop();
                }
                if (c == '}') {
                    if (stack.peek() != '{') return false;
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}
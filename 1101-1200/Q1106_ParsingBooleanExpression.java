import java.util.*;

/*
 * Using stack to simulate
 * O(n) time | O(n) space
 * 
 * 2022/11/05
 */
class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charList = expression.toCharArray();
        
        for (char c: charList) {
            if (c == '(' || c == ',') continue;
            
            if (c != ')') {
                stack.push(c);
                continue;
            }
            
            // when c == ')'
            int tCount = 0;
            int fCount = 0;
            while(stack.peek() == 't' || stack.peek() == 'f') {
                if (stack.pop() == 't') {
                    tCount++;
                } else {
                    fCount++;
                }
            }
            
            char op = stack.pop();
            switch (op) {
                case '&':
                    stack.push(fCount == 0 ? 't' : 'f');
                    break;
                case '|':
                    stack.push(tCount == 0 ? 'f' : 't');
                    break;
                case '!':
                    stack.push(fCount > 0 ? 't' : 'f');
                    break;
                default:
                    continue;
            }
        }
        
        return stack.pop() == 't';
    }
}

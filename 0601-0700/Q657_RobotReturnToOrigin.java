/**
 * 模拟题
 * 
 * 2023/07/06
 */

/**
 * O(n) time | O(1) space
 */
class Solution657 {
    public boolean judgeCircle(String moves) {
        int udCount = 0;
        int rlCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    udCount++;
                    break;
                case 'D':
                    udCount--;
                    break;
                case 'R':
                    rlCount++;
                    break;
                case 'L':
                    rlCount--;
                    break;
            }
        }
        return udCount == 0 && rlCount == 0;
    }
}
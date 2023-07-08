/**
 * Simulation
 * 
 * 2023/07/06
 */

/**
 * O(4n) = O(n) time | O(1) space
 */
class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int dir = 0;
        int x = 0, y = 0;
        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c == 'G') {
                    x += directions[dir][0];
                    y += directions[dir][1];
                } else if (c == 'L') {
                    dir = (dir + 4 - 1) % 4;
                } else if (c == 'R') {
                    dir = (dir + 1) % 4;
                }
            }
        }
        return x == 0 && y == 0;
    }
}
import java.util.*;

/**
 * Simulation 7.19 CN Daily
 * 2023/07/19
 */

/**
 * O(n + m) time | O(m) space
 * m = len(obstacles)
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }

        int maxDis = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int face = 0;
        int[] pos = new int[] { 0, 0 };
        out: for (int c : commands) {
            if (c == -1) {
                face = (face + 1) % 4;
            } else if (c == -2) {
                face = (face + 3) % 4;
            } else {
                for (int i = 0; i < c; i++) {
                    pos[0] += directions[face][0];
                    pos[1] += directions[face][1];
                    if (obs.contains(pos[0] + "," + pos[1])) {
                        pos[0] -= directions[face][0];
                        pos[1] -= directions[face][1];
                        continue out;
                    }
                    maxDis = Math.max((int) (Math.pow(pos[0], 2) + Math.pow(pos[1], 2)), maxDis);
                }
            }
        }

        return maxDis;
    }
}
/**
 * O(1) time | O(1) space
 * 
 * 2023/06/18
 */

class Solution1791 {
    public int findCenter(int[][] edges) {
        int a = edges[0][0], b = edges[0][1];
        if (a == edges[1][0] || a == edges[1][1]) return a;
        return b;
    }
}
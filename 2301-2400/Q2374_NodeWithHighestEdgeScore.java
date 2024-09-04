/**
 * 2023/01/17
 */

/**
 * O(n) time | O(1) space
 */
class Solution2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long maxScore = -1;
        int maxNode = -1;
        long[] score = new long[n];
        for (int i = 0; i < n; i++) {
            int currNode = edges[i];
            score[currNode] += i;
            if (score[currNode] > maxScore || (score[currNode] == maxScore && currNode < maxNode)) {
                maxScore = score[currNode];
                maxNode = edges[i];
            }
        }

        return maxNode;
    }
}
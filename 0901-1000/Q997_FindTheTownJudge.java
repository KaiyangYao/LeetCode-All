/**
 * Graph Theory (in/out degree)
 * 
 * O(m + n) time | O(n) space
 * m: len(trust)
 * n: len(in/out)
 * 
 * 2023/06/26
 */
class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] x: trust) {
            out[x[0]]++;
            in[x[1]]++;
        }

        for (int i = 1; i < in.length; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i; 
            }
        }

        return -1;
    }
}
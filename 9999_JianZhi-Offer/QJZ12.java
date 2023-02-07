/*
 * 剑指 Offer 12. 矩阵中的路径
 * 
 * 
 * O(MN⋅3^L) time
 * 一个非常宽松的上界为 O(MN⋅3^L), 其中 M,N 为网格的长度与宽度，L  为字符串 word 的长度。在每次调用函数 dfs 时，
 * 除了第一次可以进入 4 个分支以外，其余时间我们最多会进入 3 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。
 * 由于单词长为 L，故 dfs(i,j,0) 的时间复杂度为 O(3^L)
 * 人话：每个格子不考虑枝剪最多O(3^L)，一共有M*N的格子
 * 
 * 而我们要执行 O(MN) 次检查。然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，终止递归流程。
 * 因此，实际的时间复杂度会远远小于 Θ(MN⋅3^L)
 * 
 * 
 * O(L) space
 * dfs的栈深度最多为L
 * 
 * Same as Leetcode #79
 * 
 * 2023/02/06
 */
class QJZ12 {
    int[][] directions = new int[][] {{-1, 0, 1, 0}, {0, 1, 0, -1}};
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, r, c, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, char[] words, int index) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != words[index]) {
            return false;
        }

        if (index == words.length - 1) {
            return true;
        }

        // board[r][c] == words[index]
        board[r][c] = ' ';
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            result = result || dfs(board, r + directions[0][i], c + directions[1][i], words, index + 1);
        }
        board[r][c] = words[index];

        return result;
    }
}
/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    private boolean writeFlag;
    public void solveSudoku(char[][] board) {
        writeFlag = true;
        dfs(board, 0 ,0);
    }
    private void dfs(char[][] board, int i, int j) {
        if (i == board.length) {
            writeFlag = false;
            return;
        }
        if (board[i][j] != '.') {
            if (j == board.length - 1) { dfs(board,i+1,0); }
            else { dfs(board, i, j + 1); }
        }
        for (char k = '1'; k <= '9'; k++) {
            if (board[i][j] == '.' && isValid(board, i, j, k)) {
                board[i][j] = k;
                if (j == board.length - 1) {
                    dfs(board, i + 1, 0);
                } else {
                    dfs(board, i, j + 1);
                }
                if (writeFlag) { board[i][j] = '.'; }
            }
        }
    }
    private boolean isValid(char[][] board, int i, int j, char k) {
        for (int r = 0; r < 9; r++) {
            if (board[r][j] == k) { return false; }
        }
        for (int c = 0; c < 9; c++) {
            if (board[i][c] == k) { return false; }
        }
        int r = i / 3 * 3, c = j / 3 * 3;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[r + x][c + y] == k) { return false; }
            }
        }
        return true;
    }
}
// @lc code=end


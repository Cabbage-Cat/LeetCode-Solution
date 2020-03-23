/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    boolean[][] vis;
    char[][] board;
    int row;
    int col;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) { return; }
        vis = new boolean[board.length][board[0].length];
        row = board.length;
        col = board[0].length;
        this.board = board;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') { dfs(i, 0); }
            if (board[i][col - 1] == 'O') { dfs(i, col - 1); }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') { dfs(0, i); }
            if (board[row - 1][i] == 'O') { dfs(row - 1, i); }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!vis[i][j]) { board[i][j] = 'X'; }
            }
        }
    }
    private void dfs(int x, int y) {
        vis[x][y] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (isValid(xx, yy) && !vis[xx][yy] && board[xx][yy] == 'O') { dfs(xx, yy); }
        }
    }
    private boolean isValid(int x, int y) {
        return x > -1 && x < row && y > -1 && y < col;
    }
}
// @lc code=end


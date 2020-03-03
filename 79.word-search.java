/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private char[][] board;
    private String word;
    private boolean[][] vis;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean res;
    // up down left right
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 ||
            board[0] == null || board[0].length == 0 ||
            word == null || word.length() == 0) { return false; }
        this.board = board;
        this.word = word;
        this.vis = new boolean[board.length][board[0].length];
        this.res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !res) { dfs(i, j, 0); }
            }
        }
        return res;
    }
    private void dfs(int x, int y, int index) {
        if (res) { return; }
        else if (index == word.length() - 1 && board[x][y] == word.charAt(index)) { res = true; }
        else if (index > word.length() - 1) { return; }
        else {
            boolean isMatch = word.charAt(index) == board[x][y];
            if (isMatch) {
                vis[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (isValid(xx, yy) && !vis[xx][yy]) { dfs(xx, yy, index + 1); }
                }
                vis[x][y] = false;
            }
        }
    }
    private boolean isValid(int i, int j) {
        int x = board.length;
        int y = board[0].length;
        return i > -1 && i < x && j > -1 && j < y;
    }

}
// @lc code=end


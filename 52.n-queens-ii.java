/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int nQueensSolutionCount;
    public int totalNQueens(int n) {
        nQueensSolutionCount = 0;
        int[] queens = new int[n];
        boolean[][] vis = new boolean[4][2 * n + 1];
        dfs(queens, vis, 0);
        return nQueensSolutionCount;
    }
    private void dfs(int[] queens, boolean[][] vis, int n) {
        // vis[0][n] n row has been used.
        // vis[1][n] n col has been used.
        // vis[2][i + n]
        // vis[3][n - i + queens.length]
        if (n == queens.length) { nQueensSolutionCount++; }
        // nth row
        for (int i = 0; i < queens.length; i++) {
            // if i col can use.
            if (!vis[1][i] && !vis[0][n] && !vis[2][i + n] && !vis[3][n - i + queens.length]) {
                vis[1][i] = vis[0][n] = vis[2][i + n] = vis[3][n - i + queens.length] = true;
                queens[n] = i;
                dfs(queens, vis, n + 1);
                vis[1][i] = vis[0][n] = vis[2][i + n] = vis[3][n - i + queens.length] = false;
            }
        }
    }
}
// @lc code=end


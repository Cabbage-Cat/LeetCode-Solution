/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        boolean[][] vis = new boolean[4][2 * n + 1];
        dfs(queens, vis, 0, res);
        return res;
    }
    private void dfs(int[] queens, boolean[][] vis, int n, List<List<String>> res) {
        // vis[0][n] n row has been used.
        // vis[1][n] n col has been used.
        // vis[2][i + n]
        // vis[3][n - i + queens.length]
        if (n == queens.length) { addRes(queens, res); }
        // nth row
        for (int i = 0; i < queens.length; i++) {
            // if i col can use.
            if (!vis[1][i] && !vis[0][n] && !vis[2][i + n] && !vis[3][n - i + queens.length]) {
                vis[1][i] = vis[0][n] = vis[2][i + n] = vis[3][n - i + queens.length] = true;
                queens[n] = i;
                dfs(queens, vis, n + 1, res);
                vis[1][i] = vis[0][n] = vis[2][i + n] = vis[3][n - i + queens.length] = false;
            }
        }
    }
    private void addRes(int[] queens, List<List<String>> res){
        ArrayList<String> tmp = new ArrayList<>();
        for (int queen : queens) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queen == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            tmp.add(sb.toString());
        }
        res.add(tmp);
    }
}
// @lc code=end

